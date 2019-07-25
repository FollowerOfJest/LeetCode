/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index]) {
                if(count==2){
                    continue;
                }else{
                    count++;
                    nums[++index] = nums[i];
                }
            } else {
                nums[++index] = nums[i];
                count = 1;
            }
        }
        return index + 1;
    }
}
