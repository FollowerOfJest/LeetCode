package LeetCode;

/**
 * Created by 54359 on 2017/6/27.
 */
public class _33_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int result =-1;
        int begin=0,end=nums.length-1;
        while(begin<=end){
            int mid=(begin+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target &&nums[mid]<nums[end]){
                if(nums[end]==target){
                    return end;
                }else if(nums[end]<target){     //要判断去前边找还是后边找
                    end=mid-1;
                }else {
                    begin=mid+1;
                }
            }else if(nums[mid]>target &&nums[mid]>nums[end]){
                if(nums[begin]==target){
                    return begin;
                }else if(nums[begin]<target){   //要判断去前边找还是后边找
                    end=mid-1;
                }else {
                    begin=mid+1;
                }
            }else if(nums[mid]<target &&nums[mid]>nums[end]){
                begin=mid+1;
                //end--;    //不要有这句，因为可能并没有出现倒序 比如12345
            }else {
                //begin++;  //不要有这句，因为可能并没有出现倒序 比如12345
                end=mid-1;
            }
        }
        return  result;
    }
}
