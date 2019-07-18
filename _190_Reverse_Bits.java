package LeetCode;

/**
 * Created by 54359 on 2017/12/27.
 */
public class _190_Reverse_Bits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n & 1;
            n >>= 1;
        }
        return result;
    }


}
