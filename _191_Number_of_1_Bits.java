package LeetCode;

/**
 * Created by 54359 on 2017/12/28.
 */
public class _191_Number_of_1_Bits {
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>= 1;
        }
        return result;
    }

    public int hammingWeight_1(int n) {
        int result = 0;
        String string = Integer.toBinaryString(n);
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }


}
