import java.util.HashMap;
import java.util.Map;

public class Solution2588 {

    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Long> countMap = new HashMap<>();
        long result = 0; // 使用 long 避免溢出
        int xorSum = 0;  // 前缀异或和

        // 初始情况：xorSum 为 0 出现过一次
        countMap.put(0, 1L);

        for (int num : nums) {
            xorSum ^= num;  // 计算前缀 XOR

            // 直接获取次数并累加
            long count = countMap.getOrDefault(xorSum, 0L);
            result += count;

            // 更新 countMap，只访问一次哈希表
            countMap.put(xorSum, count + 1);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
