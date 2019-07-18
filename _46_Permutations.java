package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54359 on 2017/12/30.
 */
public class _46_Permutations {

    //这个题目里是nums里没有重复
    //通过了，但是很慢
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        int length = nums.length;
        recursion(nums, result, new ArrayList<Integer>(), length);
        return result;
    }
    //这个递归感觉等同于穷举
    public void recursion(int[] nums, List<List<Integer>> result, List<Integer> temp, int length) {
        if (temp.size() == length) {
            result.add(temp);
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!temp.contains(nums[i])) {
                List<Integer> list = new ArrayList<>(temp);
                list.add(nums[i]);
                recursion(nums, result, list, length);
            }
        }
    }

        //这种写法跟上边一样，但是这个快乐很多，应该是不需要每次创建新的arraryList，
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> list = new ArrayList<>();
//        // Arrays.sort(nums); // not necessary
//        backtrack(list, new ArrayList<>(), nums);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
//        if(tempList.size() == nums.length){
//            list.add(new ArrayList<>(tempList));          //这里
//        } else{
//            for(int i = 0; i < nums.length; i++){
//                if(tempList.contains(nums[i])) continue; // element already exists, skip
//                tempList.add(nums[i]);
//                backtrack(list, tempList, nums);
//                tempList.remove(tempList.size() - 1);     //这里
//            }
//        }
//    }

        //这个更快，没有判断contain的方法，学习下
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> permutations = new ArrayList<>();
//        if (nums.length == 0) {
//            return permutations;
//        }
//
//        collectPermutations(nums, 0, new ArrayList<>(), permutations);
//        return permutations;
//    }
//
//    private void collectPermutations(int[] nums, int start, List<Integer> permutation,
//                                     List<List<Integer>>  permutations) {
//
//        if (permutation.size() == nums.length) {
//            permutations.add(permutation);
//            return;
//        }
//
//        for (int i = 0; i <= permutation.size(); i++) {
//            List<Integer> newPermutation = new ArrayList<>(permutation);
//            newPermutation.add(i, nums[start]);
//            collectPermutations(nums, start + 1, newPermutation, permutations);
//        }
//    }
}
