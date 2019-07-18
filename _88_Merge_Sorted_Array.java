package LeetCode;

/**
 * Created by 54359 on 2017/7/16.
 */
public class _88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int a = m - 1, b = n - 1;
        while (a >= 0 || b >= 0) {
            if (a<0){
                while (b>=0){
                    nums1[index--]=nums2[b--];
                }
                return;
            }
            if (b<0){
                while (a>=0){
                    nums1[index--]=nums1[a--];
                }
                return;
            }
            if (nums1[a] > nums2[b]) {
                nums1[index--] = nums1[a--];
            } else {
                nums1[index--] = nums2[b--];
            }
        }

    }


    //把两个有序数组合并到nums1里边去，从前边合并比较麻烦，所以从后边开始合并
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        for (; index >= 0; index--) {
            if (m == 0) {
                while (index >= 0) {
                    nums1[index] = nums2[n - 1];
                    index--;
                    n = n - 1;
                }
            } else if (n == 0) {
                return;
            } else {
                if (nums2[n - 1] >= nums1[m - 1]) {
                    nums1[index] = nums2[n - 1];
                    n = n - 1;
                } else {
                    nums1[index] = nums1[m - 1];
                    m = m - 1;
                }
            }

        }
    }
}
