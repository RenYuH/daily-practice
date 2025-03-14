import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2523 {

    public static void main(String[] args) {
        int[] pair = new Solution2523().closestPrimes(11, 19);
        System.out.println(pair[0]);
        System.out.println(pair[1]);
    }

    //    public int[] closestPrimes(int left, int right) {
//        boolean[] isPrime = sieve(right); // 预计算质数
//        int prevPrime = -1, minDiff = Integer.MAX_VALUE;
//        int[] ans = {-1, -1};
//
//        // 遍历 [left, right]，找到最近的两个质数
//        for (int i = left; i <= right; i++) {
//            if (isPrime[i]) {
//                if (prevPrime != -1) {
//                    int diff = i - prevPrime;
//                    if (diff < minDiff) {
//                        minDiff = diff;
//                        ans[0] = prevPrime;
//                        ans[1] = i;
//                    }
//                }
//                prevPrime = i; // 更新前一个质数
//            }
//        }
//
//        return ans;
//    }
//
//    // **埃氏筛法** 计算所有 `<= max` 的质数
//    private boolean[] sieve(int max) {
//        boolean[] isPrime = new boolean[max + 1];
//        Arrays.fill(isPrime, true);
//        isPrime[0] = isPrime[1] = false; // 0 和 1 不是质数
//
//        for (int i = 2; i * i <= max; i++) {
//            if (isPrime[i]) {
//                for (int j = i * i; j <= max; j += i) {
//                    isPrime[j] = false; // 标记 `j` 为非质数
//                }
//            }
//        }
//        return isPrime;
//    }
    public int[] closestPrimes(int left, int right) {
        // 1. 使用欧拉筛法找出 [2, right] 内的所有质数
        boolean[] isPrime = new boolean[right + 1];
        List<Integer> primes = linearSieve(right, isPrime);

        // 2. 遍历 [left, right] 找最小的质数对
        int prevPrime = -1;
        int minDiff = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        for (int prime : primes) {
            if (prime < left) continue; // 过滤掉小于 left 的质数
            if (prevPrime != -1) {
                int diff = prime - prevPrime;
                if (diff < minDiff) {
                    minDiff = diff;
                    result[0] = prevPrime;
                    result[1] = prime;
                }
            }
            prevPrime = prime;
        }

        return result;
    }

    // **欧拉筛法（线性筛）O(n)**
    private List<Integer> linearSieve(int max, boolean[] isPrime) {
        List<Integer> primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int prime : primes) {

                if (i * prime > max) {
                    break;
                }

                isPrime[i * prime] = false;

                if (i % prime == 0) {
                    break; // 保证每个数只被其最小质因子筛去一次
                }
            }
        }
        return primes;
    }
}
