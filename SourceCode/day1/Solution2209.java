public class Solution2209 {

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();

        // 调换dp数组维度：dp[j][i]，表示使用j条地毯时，前i块砖的最小白色砖块数
        int[][] dp = new int[numCarpets + 1][n + 1];

        // 填充DP数组
        for (int j = 0; j <= numCarpets; j++) { // 外层循环：地毯数
            for (int i = 1; i <= n; i++) { // 内层循环：砖块数
                // 不铺地毯的情况（继承前i-1的值）
                dp[j][i] = dp[j][i - 1] + (floor.charAt(i - 1) == '1' ? 1 : 0);

                // 如果有地毯可用，尝试覆盖 推理过程一直在拿两种情况来对比，第一种是当前所处数组坐标位置 假如没有盖的情况，
                // 第二种是地毯在当前坐标往前推地毯长度的坐标并且少用一个毯子的情况下来对比
                if (j > 0) {
                    int coverStart = Math.max(0, i - carpetLen);
                    dp[j][i] = Math.min(dp[j][i], dp[j - 1][coverStart]);
                }
            }
        }

        // 打印 dp 数组
        printDPArray(dp);

        return dp[numCarpets][n];
    }

    private void printDPArray(int[][] dp) {
        System.out.println("DP Table (地毯数 vs 砖块位置):");
        for (int j = 0; j < dp.length; j++) {
            System.out.print("Carpets " + j + " | ");
            for (int i = 0; i < dp[j].length; i++) {
                System.out.printf("%2d ", dp[j][i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution2209 solution = new Solution2209();
        String floor = "10110111";
        int numCarpets = 2;
        int carpetLen = 2;
        int result = solution.minimumWhiteTiles(floor, numCarpets, carpetLen);
        System.out.println("最少未覆盖的白色砖块数：" + result);
    }
}
