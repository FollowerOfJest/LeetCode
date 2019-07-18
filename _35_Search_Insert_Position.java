package LeetCode;

/**
 * Created by 54359 on 2017/6/25.
 */
public class _35_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    //典型的二分查找
    public int searchInsert_1(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return begin;
    }
}
