package LeetCode;

/**
 * Created by 54359 on 2017/10/4.
 */
public class _69_Sqrt_x {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int lo = 1, hi = x / 2, mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (mid == x / mid) {
                break;
            } else if (mid < x / mid) {
                lo = mid + 1;
                if (lo > x / lo) {
                    break;
                }
            } else {
                hi = mid - 1;
            }
        }
        return mid;
    }


    //二分法，但是最开始写mid*mid>x，这种写法超时了。改成了底下这种写法
    //想明白了，mid*mid 两个int，越界了
    public int mySqrt_1(int x) {
        if (x == 0) return 0;
        int begin = 1;
        int end = x;
        int mid = 0;
        while (true) {
            mid = (begin + end) / 2;
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    begin = mid + 1;
                }
            }
        }
    }
    /*位运算的方法，值得看一看
    public int mySqrt(int x) {
        long ans = 0;
        long bit = 1l << 16;
        while(bit > 0) {
            ans |= bit;
            if (ans * ans > x) {
                ans ^= bit;
            }
            bit >>= 1;
        }
        return (int)ans;
    }
    */

}
