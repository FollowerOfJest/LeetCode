package LeetCode;

/**
 * Created by 54359 on 2017/12/30.
 */
public class _204_Count_Primes {

    public int countPrimes_2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

    public int countPrimes(int n) {
        boolean[] m = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (m[i])
                continue;

            count++;
            for (int j = i; j < n; j = j + i)       //这里把是质数的，他的倍数的值全部设置为true，说明这些值不是质数
                m[j] = true;
        }

        return count;
    }

    //超时
    public static int countPrimes_1(int n) {
        int result = 1;
        if (n <= 2) return 0;
        if (n == 3) return 1;
        for (int i = 3; i < n; i = i + 2) {
            if (isPrime(i))
                result++;
        }
        return result;
    }

    public static boolean isPrime(int n) {
        for (int i = 3; i < n / 2; i = i + 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


}
