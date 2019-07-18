package LeetCode;

/**
 * Created by 54359 on 2017/7/13.
 */
public class _80_Remove_Duplicates_from_Sorted_Array_II {
    //思路和之前的这种题一样。。就是还要操作数组，不能只计算结果不管数组
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
