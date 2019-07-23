import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */
class Solution {
    public List<List<Integer>> subsets_1(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList());
        List<Integer> temp = new ArrayList();
        for (int i = 1; i <= nums.length; i++) {
            recursion(result, temp, nums.length - 1, i, 0, nums);
        }

        return result;
    }

    public void recursion(List<List<Integer>> result, List<Integer> temp, int n, int k, int index, int[] nums) {
        if (temp.size() == k) {
            result.add(new ArrayList(temp));
            return;
        }
        for (int i = index; i <= (n - (k - temp.size()) + 1); i++) {
            temp.add(nums[i]);
            recursion(result, temp, n, k, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsets_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    //位运算
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int bit_nums = nums.length;
        int ans_nums = 1 << bit_nums; //执行 2 的 n 次方
        for (int i = 0; i < ans_nums; i++) {
            List<Integer> tmp = new ArrayList<>();
            int count = 0; //记录当前对应数组的哪一位
            int i_copy = i; //用来移位
            while (i_copy != 0) { 
                if ((i_copy & 1) == 1) { //判断当前位是否是 1
                    tmp.add(nums[count]);
                }
                count++;
                i_copy = i_copy >> 1;//右移一位
            }
            ans.add(tmp);
    
        }
        return ans;
    }

    //迭代法
    public List<List<Integer>> subsets_3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());//初始化空数组
        for(int i = 0;i<nums.length;i++){
            List<List<Integer>> ans_tmp = new ArrayList<>();
            //遍历之前的所有结果
            for(List<Integer> list : ans){
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(nums[i]); //加入新增数字
                ans_tmp.add(tmp);
            }
            ans.addAll(ans_tmp);
        }
        return ans;
    }
    

}
