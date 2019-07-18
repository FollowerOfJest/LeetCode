package LeetCode;

/**
 * Created by 54359 on 2017/10/5.
 */
public class _70_Climbing_Stairs {

    public int climbStairs_other(int n) {
        int a = 1, b = 1;
        while (n-- > 0)
            a = (b += a) - a;
        return a;
    }

    //递归没错，但超时了
    public static int climbStairs_digui(int n) {
        if (n <= 2) return n;
        return climbStairs_digui(n - 1) + climbStairs_digui(n - 2);
    }

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs_digui(6));
    }

    //到某个位置的方法为到前一个位置（跳1到这个位置）的方法+到前前一个位置（跳2到这个位置）的方法的和
    public int climbStairs_1(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        int[] temp = new int[n];
        temp[0] = 1;
        temp[1] = 2;
        for (int i = 2; i < n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[n - 1];
    }
}
