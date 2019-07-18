package LeetCode;

/**
 * Created by 54359 on 2017/7/24.
 */
public class _189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if (k == 0) return;
        fanzhuan(nums, 0, length - 1 - k);
        fanzhuan(nums, length - k, length - 1);
        fanzhuan(nums, 0, length - 1);
    }

    public void fanzhuan(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }

//    //在书里看过这个的解法，先把前半部分翻转，在翻转后半部分，再把整个翻转
//    //搞错意思了最开始，题目是把这个循环右移k位，不是对k+1位直接旋转
//    public void rotate(int[] nums, int k) {
//        k=k%nums.length;
//        if(k==0) return;
//        reverse(nums,0,nums.length-k-1);
//        reverse(nums,nums.length-k,nums.length-1);
//        reverse(nums,0,nums.length-1);
//    }
//    public void reverse(int[] nums,int begin,int end){
//        while(begin<end){
//            int temp=nums[begin];
//            nums[begin]=nums[end];
//            nums[end]=temp;
//            begin++;
//            end--;
//        }
//    }
}
