class Solution2595 {

    public static void main(String[] args) {
        Solution2595 solution2595 = new Solution2595();
        int[] arr= solution2595.evenOddBit(50);
        for (int i: arr){
            System.out.println(i);
        }
    }

    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        int index = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (index % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            n >>= 1;
            index++;
        }
        return new int[]{even, odd};
    }
}