import java.util.*;

public class Solution15 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,-1,0};
        List<List<Integer>> lists = new Solution15().threeSum(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int n1 = nums[i];
                int n2 = nums[left];
                int n3 = nums[right];
                if (n1 > 0){
                    break;
                }
                if (n3 < 0){
                    break;
                }
                int sum = n1+n2+n3;
                if (sum == 0){
                    result.add(List.of(n1, n2, n3));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left ++;
                    right --;
                } else if (sum > 0) {
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return result;
    }
}
