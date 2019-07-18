package LeetCode;

import java.util.HashSet;

/**
 * Created by 54359 on 2017/12/30.
 */
public class _202_Happy_Number {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int yushu = 0;
        int temp = 0;
        while (n != 1) {
            while (n != 0) {
                yushu = n % 10;
                temp += yushu * yushu;
                n = n / 10;
            }
            n = temp;
            temp = 0;
            if (set.contains(n)) return false;
            else set.add(n);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
