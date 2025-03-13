import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution2597 {

    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, TreeMap<Integer, Integer>> groups =
                new HashMap<>();
        for(int x : nums){
            groups.computeIfAbsent(x%k,
                    i -> new TreeMap<>()).merge(x, 1, Integer::sum);
        }

        int ans = 1;
        for(TreeMap<Integer, Integer> cnt : groups.values()) {
            int m = cnt.size();
            int f[] = new int[m+1];
            f[0] = 1;
            int i = 1;
            int pre = 0;
            for(Map.Entry<Integer, Integer> e: cnt.entrySet()){
                int x = e.getKey();
                int c = e.getValue();
                if(i > 1 && x - pre == k) {
                    f[i] = f[i-1] + f[i-2] * ((1<<c) -1 );
                } else {
                    f[i] = f[i-1] << c;
                }
                pre = x;i++;
            }
            ans *= f[m];
        }

        return ans - 1 ;
    }

//    public int beautifulSubsets(int[] nums, int k) {
//        Map<Integer, Integer> countMap = new HashMap<>();
//        return backtrack(nums, k, 0, countMap) - 1; // 减去空集
//    }
//
//    private int backtrack(int[] nums, int k, int index, Map<Integer, Integer> countMap) {
//        if (index == nums.length) {
//            return 1; // 计算当前子集
//        }
//
//        // 选择不加入 nums[index]
//        int count = backtrack(nums, k, index + 1, countMap);
//
//        // 选择加入 nums[index]，但需检查是否合法
//        int num = nums[index];
//        if (!countMap.containsKey(num - k) && !countMap.containsKey(num + k)) {
//            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//            count += backtrack(nums, k, index + 1, countMap);
//            countMap.put(num, countMap.get(num) - 1);
//            if (countMap.get(num) == 0) {
//                System.out.println("index:" + index + " num:" + num);
//                countMap.remove(num);
//            }
//        }
//
//        return count;
//    }

    public static void main(String[] args) {
        Solution2597 solution = new Solution2597();
        int[] nums1 = {2, 4, 6, 8};
        System.out.println(solution.beautifulSubsets(nums1, 3));
    }
}
