package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by 54359 on 2017/6/22.
 */
public class _15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length < 3) return result;
        int target = 0;
        int start, end;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            target = -nums[i];
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                if (start != (i + 1)) {
                    while (nums[start] == nums[start - 1] && start < end) start++;
                }
                if (end != nums.length - 1) {
                    while (nums[end] == nums[end + 1] && start < end) end--;
                }
                if (start < end) {
                    if (nums[start] + nums[end] == target) {
                        result.add(Arrays.asList(nums[i],nums[start],nums[end]));   //这种写法记住一下
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] s = {2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4};
        Arrays.sort(s);
        List<List<Integer>> result = threeSum(s);

        System.out.println(result);

    }
   //n*n
   public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);  //先排序貌似很多都会用到nlogn
       ArrayList<List<Integer>> result=new ArrayList<>();
       for(int i=0;i<nums.length-2;i++){
           if(i==0 || (i>0 && nums[i]!=nums[i-1])){
               int j=i+1,k=nums.length-1,sum=-nums[i];
               while(j<k){
                   if(nums[j]+nums[k]==sum){//然后这里不要写成3个相加，要前边先有个sum
                       result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                       //while(j<k && nums[j]==nums[j+1]) j++;
                       //while(j<k && nums[k]==nums[k-1]) k--;
                       //j++;k--;
                       do{j++;}while(j<k && nums[j]==nums[j-1]);//这里最开始写成了num[j]==nums[j+1]是错的
                       do{k--;}while(j<k && nums[k]==nums[k+1]);//这里最开始写成了num[k]==nums[k-1]是错的
                   }else if(nums[j]+nums[k]<sum){
                       do{j++;}while(j<k && nums[j]==nums[j-1]);//这里最开始写成了num[j]==nums[j+1]是错的
                   }else{
                       do{k--;}while(j<k && nums[k]==nums[k+1]);//这里最开始写成了num[k]==nums[k-1]是错的
                   }
               }
           }
       }
       return result;
   }
   
}
