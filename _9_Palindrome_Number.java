package LeetCode;

/**
 * Created by 54359 on 2017/12/16.
 */
public class _9_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String temp = Integer.toString(Math.abs(x));
        char[] array = temp.toCharArray();
        int i = 0, N = array.length - 1;
        while (i < N) {
            if (array[i] != array[N])
                return false;
            i++;
            N--;
        }
        return true;
    }

    //网上的方法
    public boolean isPalindrome_1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))   //在这种方法中，要把这种能被10整除的先抛去
            return false;
        int temp = 0;
        while (temp < x) {
            temp = x % 10 + temp * 10;
            x = x / 10;
        }
        if (x == temp || temp/10==x)
            return true;
        return false;
    }
}
