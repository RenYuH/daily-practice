import java.util.*;

public class Solution2560 {

    public static void main(String[] args) {
        System.out.println(new Solution2560().minCapability(new int[]{5038, 3053, 2825, 3638, 4648, 3259, 4948, 4248, 4940, 2834, 109, 5224, 5097, 4708, 2162, 3438, 4152, 4134, 551, 3961, 2294, 3961, 1327, 2395, 1002, 763, 4296, 3147, 5069, 2156, 572, 1261, 4272, 4158, 5186, 2543, 5055, 4735, 2325, 1206, 1019, 1257, 5048, 1563, 3507, 4269, 5328, 173, 5007, 2392, 967, 2768, 86, 3401, 3667, 4406, 4487, 876, 1530, 819, 1320, 883, 1101, 5317, 2305, 89, 788, 1603, 3456, 5221, 1910, 3343, 4597}, 28));
    }

    public int minCapability1(int[] nums, int k) {
        if (nums.length == 1 && k == 1) {
            return nums[0];
        }
        List<Integer> numList = new ArrayList<>();
        List<Integer> numListCopy = new ArrayList<>();
        List<Integer> originCopy = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
            numListCopy.add(nums[i]);
            originCopy.add(nums[i]);
        }
        numListCopy = numListCopy.stream().sorted().toList();
        List<Integer> targets = new ArrayList<>();
        List<Integer> targetIndexes = new ArrayList<>();
        findMin(numList, numListCopy, originCopy, targets, targetIndexes, k, 0, 0);
        return targets.stream().max(Integer::compareTo).get();
    }

    public void findMin(List<Integer> numList, List<Integer> numListCopy, List<Integer> originCopy, List<Integer> targets, List<Integer> targetIndexes, int k, int seq, int start) {
        if (targets.size() == k) {
            return;
        }
        if (seq > numListCopy.size() - 1) {
            for (int i = 0; i < originCopy.size(); i++) {
                numList.set(i, originCopy.get(i));
            }
            targets.clear();
            targetIndexes.clear();
            start++;
            seq = start;
            findMin(numList, numListCopy, originCopy, targets, targetIndexes, k, seq, start);
            return;
        }
        Integer min = numListCopy.get(seq);
        int index = numList.indexOf(min);
        if (targetIndexes.contains(index + 1) || targetIndexes.contains(index - 1)) {
            numList.set(index, -1);
            seq++;
            findMin(numList, numListCopy, originCopy, targets, targetIndexes, k, seq, start);
            return;
        }
        numList.set(index, 0);
        targets.add(min);
        targetIndexes.add(index);
        seq++;
        findMin(numList, numListCopy, originCopy, targets, targetIndexes, k, seq, start);
    }

    public int minCapability(int[] nums, int k) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        int max = numList.stream().max(Integer::compareTo).get();
        int min = numList.stream().min(Integer::compareTo).get();
        while (max > min) {
            int mid = min + (max - min) / 2;
            if (robber(nums, k, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean robber(int[] nums, int k, int ability) {
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] <= ability) {
                count++;
                i++;
            }
            i++;
        }
        return count >= k;
    }

    public int minCapability2(int[] nums, int k) {
        int length = nums.length;
        int left = nums[0];
        int right = nums[0];

        for (int i = 1; i < length; i++) {
            left = Math.min(left, nums[i]);
            right = Math.max(right, nums[i]);
        }

        int ans = 0;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (check(middle, length, nums) >= k) {
                right = middle - 1;
                ans = middle;
            } else {
                left = middle + 1;
            }
        }
        return ans;
    }

    /** 方法一 动态规划：能力是 ability 时偷窃到的房间数量是多少 */
    private static int check1(int ability, int length, int[] nums) {
        if (length == 1) {
            return nums[0] <= ability ? 1 : 0;
        }

        if (length == 2) {
            return Math.min(nums[0], nums[1]) <= ability ? 1 : 0;
        }

        int[] dp = new int[length];
        dp[0] = nums[0] <= ability ? 1 : 0;
        dp[1] = Math.min(nums[0], nums[1]) <= ability ? 1 : 0;
        for (int i = 2; i < length; i++) {
            dp[i] = dp[i - 1];
            dp[i] = Math.max(dp[i], (nums[i] <= ability ? 1 : 0) + dp[i - 2]);
        }
        return dp[length - 1];
    }

    /** 方法二 贪心 */
    private static int check(int ability, int length, int[] nums) {
        int ans = 0;
        for (int i = 0; i < length; i++) {
            if(nums[i] <= ability) {
                ans++;
                i++;
            }
        }
        return ans;
    }
}
