package LeetCode;

/**
 * Created by 54359 on 2017/6/24.
 */
public class _26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates_1(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n != nums[i-1])
                nums[i++] = n;
        return i;
    }

    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        int index=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[i-1]){
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}
