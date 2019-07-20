/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */
class Solution {
    public boolean canJump(int[] nums){
        int reach=0;
        for (int i = 0; i < nums.length; i++) {
            //如果大于了，说明到不了
            if(i>reach)
                return false;
            reach=Math.max(reach,i+nums[i]);
        }
        return true;
    }
    //遍历每一种可能
    public boolean canJump_1(int[] nums) {
        boolean[] result = new boolean[nums.length];
        result[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (!result[i])
                break;
            for (int j = 1; j <= nums[i] && i+j<nums.length; j++) {
                result[i+j]=true;
            }
        }
        return result[nums.length - 1];
    }
}
