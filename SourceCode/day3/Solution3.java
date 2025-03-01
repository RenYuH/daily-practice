
import java.util.HashMap;
import java.util.Map;

class Solution3 {

    public static void main(String[] args) {
        int[] ints = new Solution3().twoSum(new int[]{3, 2, 4}, 6);
        for (int x :ints){
            System.out.println(x);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}