
public class Solution2226 {

    public static void main(String[] args) {
        System.out.println(new Solution2226().maximumCandies(new int[]{1,2,6,8,6,7,3,5,2,5}, 3));
    }

    //二分查找
    public int maximumCandies(int[] candies, long k) {
        if (k == 0) return 0;  // 特殊情况

        int low = 1, high = 0;
        for (int candy : candies) {
            high = Math.max(high, candy);  // 找到糖果堆中的最大值
        }

        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canDistribute(candies, k, mid)) {
                result = mid;  // `mid` 可行，尝试更大的值
                low = mid + 1;
            } else {
                high = mid - 1; // `mid` 过大，尝试更小的值
            }
        }
        return result;
    }

    // 判断是否能以 `candiesPerChild` 分配至少 `k` 份
    private boolean canDistribute(int[] candies, long k, int candiesPerChild) {
        if (candiesPerChild == 0) return false;

        long count = 0;
        for (int candy : candies) {
            count += candy / candiesPerChild; // 计算总共可以分出的份数
            if (count >= k) return true;  // 只要能满足 `k` 份就返回
        }
        return count >= k;
    }
}
