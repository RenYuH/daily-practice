package day9;

public class Solution1328 {

    public static void main(String[] args) {
        String abcdcba = new Solution1328().breakPalindrome("aa");
        System.out.println(abcdcba);
    }

    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return ""; // 长度为 1，无法破坏回文，直接返回空串

        char[] chars = palindrome.toCharArray();

        // 遍历前半部分，找到第一个不是 'a' 的字符，并改成 'a'
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }

        // 如果整个字符串都是 'a'，修改最后一个字符为 'b'
        chars[n - 1] = 'b';
        return new String(chars);
    }
}
