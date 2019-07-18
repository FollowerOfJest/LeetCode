package LeetCode;

/**
 * Created by 54359 on 2017/7/5.
 */
public class _66_Plus_One {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    //把一个数用数组表示出来，然后+1
    //思路就是小于9就加一显示，是9就加一进上去
    public int[] plusOne_1(int[] digits) {
        int length = digits.length;
        int[] result = new int[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        result[0] = 1;
        return result;
    }
}
