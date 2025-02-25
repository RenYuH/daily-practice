public class Solution1 {

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();

        // dp[i][k] 表示覆盖到第 i 块砖，使用了 k 条地毯后的最小白砖数
        int[][] dp = new int[n + 1][numCarpets + 1];

        // 初始化 dp 数组
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= numCarpets; k++) {
                dp[i][k] = 0;
            }
        }

        // 填充 dp 表
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <= numCarpets; k++) {
                // 不使用地毯覆盖第 i 块砖
                dp[i][k] = dp[i - 1][k] + (floor.charAt(i - 1) == '1' ? 1 : 0);

                // 使用一条地毯覆盖（如果还有地毯可用）
                if (k > 0) {
                    dp[i][k] = Math.min(dp[i][k], dp[Math.max(0, i - carpetLen)][k - 1]);
                }
            }
        }

        // 返回在覆盖全部砖块后使用 numCarpets 条地毯时剩余的白色砖块数
        return dp[n][numCarpets];
    }

    // 测试方法
    public static void main(String[] args) {
        Solution1 solver = new Solution1();

        // 测试用例 1
        String floor1 = "10110101";
        int numCarpets1 = 2;
        int carpetLen1 = 2;
        System.out.println("最少未覆盖的白砖数: " + solver.minimumWhiteTiles(floor1, numCarpets1, carpetLen1)); // 输出: 2
    }
}
