public class Solution3340 {

    public static void main(String[] args) {
        System.out.println(new Solution3340().isBalanced("12345"));
    }

    public boolean isBalanced(String num) {
        int evenSum = 0; // 偶数下标处的数字之和
        int oddSum = 0;  // 奇数下标处的数字之和

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            int digit = Character.getNumericValue(ch); // 将字符转换为数字

            // 根据下标是偶数还是奇数，将数字加到对应的和中
            if (i % 2 == 0) {
                evenSum += digit;
            } else {
                oddSum += digit;
            }
        }

        // 如果偶数下标处的数字之和等于奇数下标处的数字之和，则返回 true
        return evenSum == oddSum;
    }
}
