/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int result= nums[0];
        int temp=nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp=Math.max(nums[i],temp+nums[i]);
            result=Math.max(result,temp);
        }

        return result;
    }
}

