package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 54359 on 2017/6/24.
 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //要考虑3个重复的，2个重复的问题。
        ArrayList<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int length=nums.length;
        for(int i=0;i<length-3;i++){
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)break;  //*reduce time
            if(nums[i]+nums[length-1]+nums[length-2]+nums[length-3]<target) continue;//*reduce time
            if(i>0 && nums[i]==nums[i-1]) continue;//仔细想下这里
            for(int j=i+1;j<length-2;j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;//*reduce time
                if(nums[i]+nums[j]+nums[length-1]+nums[length-2]<target)continue;//*reduce time
                if(j>i+1 && nums[j]==nums[j-1]) continue;//仔细想下这里
                int k=j+1,l=length-1;
                int sum_i_j=nums[i]+nums[j];
                int chazhi_i_j=target-sum_i_j;
                while(k<l){
                    int sum_k_l=nums[k]+nums[l];
                    if(sum_k_l==chazhi_i_j){
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        do{
                            k++;
                        }while (k<l && nums[k]==nums[k-1]);
                        do{
                            l--;
                        }while (k<l && nums[l]==nums[l+1]);
                    }else if(sum_k_l<chazhi_i_j){
                        k++;
                    }else {
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
