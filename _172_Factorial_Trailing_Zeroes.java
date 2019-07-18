package LeetCode;

/**
 * Created by 54359 on 2017/10/13.
 */
//Given an integer n, return the number of trailing zeroes in n!.
public class _172_Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n != 0) {
            n = n / 5;
            result += n;
        }
        return result;
    }

//    //判断一个阶乘末尾有多少个0，就是判断有多少个5*2，判断有多少个5.除以5得到多少个5，但是可能像25/5=5还有5，所以要继续除
//    public int trailingZeroes(int n) {
//        int result=0;
//        while (n>0){
//            result=result+n/5;
//            n=n/5;
//        }
//        return result;
//    }
}
