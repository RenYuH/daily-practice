public class Solution132 {

    public static void main(String[] args) {
        Solution132 solution132 = new Solution132();
        System.out.println(solution132.minCut("xxabcbay"));
    }

    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n]; // dp[i] represents min cuts for s[0:i]

        // Initialize dp array with worst case (each character is a separate partition)
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        // Precompute palindrome table
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || isPalindrome[left + 1][right - 1])) {
                    isPalindrome[left][right] = true;
                }
            }
        }

        // Compute minimum cuts using DP
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0; // Whole substring s[0:i] is palindrome → no cuts needed
            } else {
                for (int j = 1; j <= i; j++) {
                    if (isPalindrome[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1]; // Min cuts needed for the whole string
    }
}
