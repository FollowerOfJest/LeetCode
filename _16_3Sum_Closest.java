package LeetCode;

import java.util.Arrays;

/**
 * Created by 54359 on 2017/6/24.
 */
public class _16_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        int temp = 0;
        int min = Integer.MAX_VALUE;
        int start, end;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                start = i + 1;
                end = nums.length - 1;
                temp = target - nums[i];
                while (start < end) {
                    int tempsum = nums[start] + nums[end];
                    if (tempsum == temp) return target;
                    if (Math.abs(tempsum - temp) <= min) {
                        result = nums[i] + tempsum;
                        min = Math.abs(tempsum - temp);
                    }
                    if (tempsum < temp) {
                        do {
                            start++;
                        } while (nums[start] == nums[start - 1] && start < end);
                    } else {
                        do {
                            end--;
                        } while (nums[end] == nums[end + 1] && start < end);
                    }
                }
            }
        }
        return result;
    }

//    //再次修改后平均速度又上来了
//    public int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int length=nums.length;
//        int min=Integer.MAX_VALUE;
//        int sum=0;
//        for(int i=0;i<length;i++){
//            int j=i+1,k=length-1,sum_j_k=target-nums[i];
//            while(j<k){
//                int sumjk=nums[j]+nums[k];  //有这一步可以让后面不出现3个相加
//                if(sum_j_k==sumjk){
//                    return target;
//                }else if(sum_j_k<sumjk){
//                    k=k-1;
//                }else{
//                    j=j+1;
//                }
//                if(min>Math.abs(sumjk-sum_j_k)){
//                    sum=nums[i]+sumjk;
//                    min=Math.abs(sumjk-sum_j_k);
//                }
//            }
//        }
//        return sum;
//    }
}
