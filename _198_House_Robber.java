package LeetCode;

/**
 * Created by 54359 on 2017/12/28.
 */
public class _198_House_Robber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int temp1 = nums[0], temp2 = Math.max(nums[0], nums[1]), temp = 0;
        for (int i = 2; i < nums.length; i++) {
            temp = temp2;
            temp2 = Math.max(nums[i] + temp1, temp2);
            temp1 = temp;
        }
        return temp2;
    }

    //正确的，但是超时了
    public static int rob_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return recursion(nums, nums.length - 1);
    }

    public static int recursion(int[] nums, int index) {
        if (index < 0) return 0;
        if (index == 0) return nums[0];
        return Math.max(nums[index] + recursion(nums, index - 2), recursion(nums, index - 1));
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 3};
        System.out.println(rob_1(a));
    }
}
