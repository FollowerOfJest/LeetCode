package LeetCode;

public class _50_Pow {
    public double myPow(double x, int n) {
        // 因为n的范围是Integer MinValue~MaxValue
        long N = n;
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        double result = 1;
        double cur = x;
        for (long i = N; i > 0; i = i / 2) {
            if (i % 2 == 1)
                result = result * cur;
            cur = cur * cur;
        }
        return result;
    }
}