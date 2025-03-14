public class Solution3356 {

    public static void main(String[] args) {
        System.out.println(new Solution3356().minZeroArray(new int[]{1,2,6,4,5},new int[][]{{0,4,4},{2,4,6}}));
    }

    //贪心算法 Greedy Algorithm + 差分数组 Difference Array + 前缀和 Prefix Sum
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, sum = 0, k = 0;
        int[] differenceArray = new int[n + 1];
        for (int index = 0; index < n; index++) {
            while (sum + differenceArray[index] < nums[index]) {
                k++;
                if (k > queries.length) {
                    return -1;
                }
                int left = queries[k - 1][0];
                int right = queries[k - 1][1];
                int val =  queries[k - 1][2];
                if (right >= index) {
                    differenceArray[Math.max(left, index)] += val;
                    differenceArray[right + 1] -= val;
                }
            }
            sum += differenceArray[index];
        }
        return k;
    }
}
