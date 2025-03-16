import java.util.Arrays;

public class Solution2272 {
    //53. 最大子数组和。同类型题目
    public int largestVariance(String s) {
        int ans = 0;
        int[][] f0 = new int[26][26];//a 是最多字符，b 是最少字符的最大波动值
        int[][] f1 = new int[26][26];//在至少出现过一次 b 的情况下，a 作为最多字符时的 maxFreq - minFreq 最大值。

        // 初始化 f1[i][j] 为负无穷，避免未初始化导致错误
        for (int[] row : f1) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        // 遍历字符串
        for (char ch : s.toCharArray()) {
            int c = ch - 'a'; // 字符转索引 0~25
            for (int i = 0; i < 26; i++) {
                if (i == c) continue;

                // 假设 `c` 作为最多字符 `a`，更新 `b = i` 的状态
                f0[c][i] = Math.max(f0[c][i], 0) + 1;
                f1[c][i]++;

                // 假设 `c` 作为最少字符 `b`，更新 `a = i` 的状态
                f0[i][c] = Math.max(f0[i][c], 0) - 1;
                f1[i][c] = f0[i][c];

                // 更新最大波动值
                ans = Math.max(ans, Math.max(f1[c][i], f1[i][c]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2272 sol = new Solution2272();
        System.out.println(sol.largestVariance("aababbb")); // 预期输出 3
    }

}
