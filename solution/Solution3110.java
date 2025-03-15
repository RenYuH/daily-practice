public class Solution3110 {

    public static void main(String[] args) {
        System.out.println(new Solution3110().scoreOfString("hello"));
    }

    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i - 1)); // 计算 ASCII 差值的绝对值
        }
        return score;
    }
}
