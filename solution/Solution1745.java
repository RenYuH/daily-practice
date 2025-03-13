public class Solution1745 {

    public static void main(String[] args) {
        boolean flag = new Solution1745().checkPartitioning("juchzcedhfesefhdeczhcujzzvbmoeombv");
        System.out.println(flag);
    }

    public boolean checkPartitioning(String s) {
        int length = s.length();
        if (length < 3) {
            return false;
        }
        //代表s[i1,i2]是否为回文串
        boolean[][] isPalindrome = new boolean[length][length];
        for (int right = 0; right < length; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || isPalindrome[left + 1][right - 1])) {
                    isPalindrome[left][right] = true;
                }
            }
        }
        Utils.printDPArray(isPalindrome);
        for (int i = 0; i < length - 2; i++) {
            for (int j = length - 1; j >= 2; j--) {
                if (isPalindrome[0][i] && isPalindrome[j][length - 1] && (length-1-j) + i < length - 1) {
                    if (isPalindrome[i + 1][j - 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
