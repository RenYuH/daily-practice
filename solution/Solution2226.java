import java.util.Arrays;

public class Solution2226 {

    public static void main(String[] args) {
        System.out.println(new Solution2226().maximumCandies(new int[]{1,2,6,8,6,7,3,5,2,5}, 3));
    }

    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        if (sum < k) {
            return 0;
        }
        long j = (sum / k);
        return find(candies, j, k);
    }

    public int find(int[] candies, long j, long k) {
        long temp = k;
        int index = -1;
        boolean flag = true;
        if (candies[0] > j){
            index = 0;
            flag = false;
        }else if (candies[candies.length - 1] < j){
            index = -1;
        }else{
            for (int i = 0; i < candies.length - 1; i++) {

                if ((candies[i + 1] > j && candies[i] < j)) {
                    index = i;
                    break;
                }else if((candies[i] == j)){
                    index = i;
                    flag = false;
                    break;
                }else if((candies[i + 1] == j)){
                    index = i;
                    break;
                }
            }
        }
        if (index == -1){
            j--;
            return find(candies, j, k);
        }else{
            if (flag){
                for (int i = candies.length - 1; i > index; i--) {
                    long m = candies[i] / j;
                    temp -= m;
                }
            }else{
                for (int i = candies.length - 1; i >= index; i--) {
                    long m = candies[i] / j;
                    temp -= m;
                }
            }

            if (temp > 0) {
                j--;
                return find(candies, j, k);
            } else {
                return (int) j;
            }
        }
    }
}
