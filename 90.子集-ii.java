/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */
class Solution {
    //位运算
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> lists = new ArrayList<>();
        int subsetNum = 1<<num.length;
        for(int i=0;i<subsetNum;i++){
            List<Integer> list = new ArrayList<>();
            boolean illegal=false;
            for(int j=0;j<num.length;j++){
                //当前位是 1
                if((i>>j&1)==1){
                    //当前是重复数字，并且前一位是 0，跳过这种情况
                    if(j>0&&num[j]==num[j-1]&&(i>>(j-1)&1)==0){
                        illegal=true;
                        break;
                    }else{
                        list.add(num[j]);
                    }
                }
            }
            if(!illegal){
                lists.add(list); 
            }
    
        }
        return lists;
    }
    

    public List<List<Integer>> subsetsWithDup_1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    } 
}

