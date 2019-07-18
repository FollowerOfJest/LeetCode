package LeetCode;

/**
 * Created by 54359 on 2017/12/25.
 */
public class _136_Single_Number {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
