package LeetCode;

/**
 * Created by 54359 on 2017/6/25.
 */
public class _53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int temp=nums[0],max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp=Math.max(nums[i],temp+nums[i]);    //最重要的就是这一步
            max=Math.max(temp,max);
        }
        return max;
    }

    //最简单的动态规划，要好好想想
    public int maxSubArray_1(int[] nums){
        int max=nums[0],temp=nums[0];
        for (int i=1;i<nums.length;i++){
            temp=Math.max(nums[i],temp+nums[i]);
            max=Math.max(temp,max);
        }
        return max;
    }
    /*  很久之前写的。。很佩服自己。。虽然很蠢。
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum=0;
        int order=0;
       	//这个循环对负数的处理，不是负了跳出
        for(;order<nums.length;order++){
            if(nums[order]<=0){
                if(nums[order]>max){
                    max=nums[order];
                }
            }else{
                break;
            }
        }
        for(;order<nums.length;order++){
            sum=sum+nums[order];
            if(sum<0){
                sum=0;
                continue;
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
     */
}

