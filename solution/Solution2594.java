import java.util.Arrays;

public class Solution2594 {

    public static void main(String[] args) {
        System.out.println(new Solution2594().repairCars(new int[]{2,4,6,8},200));
    }

    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);  // 排序可以让二分更稳定
        long low = 1, high = (long) ranks[0] * (long) cars * cars;
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canFixAllCars(ranks, cars, mid)) {
                result = mid;  // 记录可能的最小时间
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    // 判断在 `timeLimit` 时间内是否可以修完 `cars` 辆汽车
    private boolean canFixAllCars(int[] ranks, int cars, long timeLimit) {
        long totalCarsFixed = 0;
        for (int rank : ranks) {
            long maxCarsByWorker = (long) Math.sqrt(timeLimit / rank); // 计算当前工人最多能修多少车
            totalCarsFixed += maxCarsByWorker;
            if (totalCarsFixed >= cars) return true; // 只要满足修完 `cars` 辆，立即返回
        }
        return totalCarsFixed >= cars;
    }
}
