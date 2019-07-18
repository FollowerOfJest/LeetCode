package LeetCode;

import java.util.*;

/**
 * Created by 54359 on 2017/7/16.
 */
public class _90_Subsets_II {
    /*  //这个是抄的
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        helper(res, each, 0, nums);
        return res;
    }
    public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        if (pos <= n.length) {
            res.add(each);
        }
        int i = pos;
        while (i < n.length) {
            each.add(n[i]);
            helper(res, new ArrayList<>(each), i + 1, n);
            each.remove(each.size() - 1);
            i++;
            while (i < n.length && n[i] == n[i - 1]) {i++;}
        }
        return;
    }
     */
    //这个是根据78之后改的，记得加个sort
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int length=nums.length;
        if(length==0) return result;
        recursion(result,temp,nums,0,length);
        result.add(new ArrayList<>());  //这里加上[]
        return result;
    }

    public void recursion(List<List<Integer>> result,List<Integer> temp,int[] nums,int index,int length){
        for(;index<length;){
            temp.add(nums[index]);
            result.add(new ArrayList<>(temp));  //这种写法底下要有remove。注意这里加上的东西
            recursion(result,temp,nums,index+1,length);
            temp.remove(temp.size()-1);
            index=index+1;
            while (index < length && nums[index] == nums[index - 1]) {index++;}
        }
    }
}
