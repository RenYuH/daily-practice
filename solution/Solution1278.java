import java.util.Arrays;

public class Solution1278 {

    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        // 预处理 cost[i][j]，表示 s[i:j] 变成回文串的最小修改次数
        for (int len = 2; len <= n; len++) { // 遍历子串长度
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                cost[i][j] = cost[i + 1][j - 1] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
            }
        }
        Utils.printDPArray(cost);
        // 动态规划 dp[i][j]：s[0:i] 分成 j 份的最小修改次数
        int[][] dp = new int[n][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // 初始化，分成 1 组的情况
        for (int i = 0; i < n; i++) {
            dp[i][1] = cost[0][i];
        }
        Utils.printDPArray(dp);
        // 计算 dp[i][j]
        for (int j = 2; j <= k; j++) { // 分割成 j 份
            for (int i = j - 1; i < n; i++) { // 至少要有 j 个字符
                for (int m = j - 2; m < i; m++) { // 枚举最后一段的起点
                    dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + cost[m + 1][i]);
                }
            }
        }
        Utils.printDPArray(dp);
        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1278().palindromePartition("jjj",5));
    }
}
