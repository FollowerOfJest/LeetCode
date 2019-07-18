package LeetCode;

/**
 * Created by 54359 on 2017/7/11.
 */
public class _75_Sort_Colors {
    public void sortColors(int[] nums) {
        int length=nums.length;
        if(length==0 || length==1) return;
        int begin=0,end=length-1;
        int temp;
        int index=0;
        while(index<=end){  //这里最开始错了，没加=好，然后这里写begin<end是不对的
            while(nums[index]==2 && index<end){
                temp=nums[end];
                nums[end--]=nums[index];
                nums[index]=temp;
            }
            while (nums[index]==0 && index>begin){
                temp=nums[begin];
                nums[begin++]=nums[index];
                nums[index]=temp;
            }
            index++;
        }
    }
}
