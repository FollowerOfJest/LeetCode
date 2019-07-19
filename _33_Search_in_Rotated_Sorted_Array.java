package LeetCode;

/**
 * Created by 54359 on 2017/6/27.
 */
public class _33_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int result = -1;
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target && nums[mid] < nums[end]) {
                if (nums[end] == target) { // 12345 5
                    return end;
                } else if (nums[end] < target) { // 要判断去前边找还是后边找 45123 4 前边找
                    end = mid - 1;
                } else { // 45123 2 后边找
                    begin = mid + 1;
                }
            } else if (nums[mid] > target && nums[mid] > nums[end]) {
                if (nums[begin] == target) {
                    return begin;
                } else if (nums[begin] < target) { // 要判断去前边找还是后边找
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else if (nums[mid] < target && nums[mid] > nums[end]) { // 23451 5
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    // 下边为官网解法
    int[] nums;
    int target;

    public int find_rotate_index(int left, int right) {
        // 12345
        if (nums[left] < nums[right])
            return 0;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])  //34512     
                return pivot + 1;
            else {                          //51234
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else                    //23451
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public int search(int left, int right) {
        /*
         * Binary search
         */
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

    public int search_1(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length;

        if (n == 0)
            return -1;
        if (n == 1)
            return this.nums[0] == target ? 0 : -1;

        int rotate_index = find_rotate_index(0, n - 1);

        // if target is the smallest element
        if (nums[rotate_index] == target)
            return rotate_index;
        // if array is not rotated, search in the entire array
        if (rotate_index == 0)
            return search(0, n - 1);
        if (target < nums[0])
            // search in the right side
            return search(rotate_index, n - 1);
        // search in the left side
        return search(0, rotate_index);
    }

}
