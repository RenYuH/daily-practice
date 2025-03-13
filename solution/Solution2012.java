public class Solution2012 {

    public static void main(String[] args) {
        System.out.println(new Solution2012().sumOfBeauties(new int[]{2,4,6,4}));
    }

    public int sumOfBeauties(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int summary = 0;
        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i <= nums.length - 1; i++) {
            prefix[i] = Math.max(prefix[i - 1], nums[i - 1]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], nums[i + 1]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            int current = 0;
            if (suffix[i] > prefix[i] && prefix[i] < nums[i] && suffix[i] > nums[i]) {
                current = 2;
            } else if (nums[i - 1] < nums[i] && nums[i + 1] > nums[i]) {
                current = 1;
            }
            summary += current;
        }
        return summary;
    }
}
