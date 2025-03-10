package day5;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {

    public static void main(String[] args) {
        List<List<String>> result = new day5.Solution131().partition("abcccd");
        System.out.println(result);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        int length = s.length();
        // 预计算 isPalindrome[i][j]，减少回溯时的重复计算
        boolean[][] isPalindrome = new boolean[length][length];
        for (int right = 0; right < length; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || isPalindrome[left + 1][right - 1])) {
                    isPalindrome[left][right] = true;
                }
            }
        }
        // 开始回溯
        backtrack(s, 0, path, res, isPalindrome);
        return res;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> res, boolean[][] isPalindrome) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path)); // 记录当前有效的分割方案
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome[start][end]) { // 剪枝：只尝试回文子串
                path.add(s.substring(start, end + 1));
                System.out.println(path);
                backtrack(s, end + 1, path, res, isPalindrome); // 递归搜索剩余部分
                path.remove(path.size() - 1); // 回溯
                System.out.println(path);
            }
        }
        //process
        //1[a]
        //2[a, b]
        //3[a, b, c]
        //4[a, b, c, c]
        //5[a, b, c, c, c]
        //6[a, b, c, c, c, d]
        //7[a, b, c, c, c]
        //8[a, b, c, c]
        //9[a, b, c]
        //10[a, b, c, cc]
        //11[a, b, c, cc, d]
        //12[a, b, c, cc]
        //13[a, b, c]
        //14[a, b]
        //15[a, b, cc]
        //16[a, b, cc, c]
        //17[a, b, cc, c, d]
        //18[a, b, cc, c]
        //19[a, b, cc]
        //20[a, b]
        //21[a, b, ccc]
        //22[a, b, ccc, d]
        //23[a, b, ccc]
        //24[a, b]
        //25[a]
        //26[]
        //result:[[a, b, c, c, c, d], [a, b, c, cc, d], [a, b, cc, c, d], [a, b, ccc, d]]
    }
}
