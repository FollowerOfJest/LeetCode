package LeetCode;

import java.util.*;

/**
 * Created by 54359 on 2017/12/30.
 */
public class _46_Permutations {

    // 这个题目里是nums里没有重复
    // 通过了，但是很慢
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null)
            return result;
        int length = nums.length;
        recursion(nums, result, new ArrayList<Integer>(), length);
        return result;
    }

    // 这个递归感觉等同于穷举
    public static void recursion(int[] nums, List<List<Integer>> result, List<Integer> temp, int length) {
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

    public static void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));

        for (int i = first; i < n; i++) {
            // 这个集合类的用法，交换first位置和i位置，第一次的循环就是不变
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    // 官方的题解
    public static List<List<Integer>> permute_2(int[] nums) {
        // init output list
        List<List<Integer>> output = new ArrayList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = permute(new int[] { 1, 2, 3 });
        for (List<Integer> list : result) {
            System.out.println(list);
        }

    }

    // 这种写法跟上边一样，但是这个快乐很多，应该是不需要每次创建新的arraryList，
    public List<List<Integer>> permute_3(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList)); // 这里
        } else {
            //这里可以换成bitmap来记录使用情况
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]))
                    continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1); // 这里
            }
        }
    }

    // 这个更快，没有判断contain的方法，学习下
    // public List<List<Integer>> permute(int[] nums) {
    // List<List<Integer>> permutations = new ArrayList<>();
    // if (nums.length == 0) {
    // return permutations;
    // }
    //
    // collectPermutations(nums, 0, new ArrayList<>(), permutations);
    // return permutations;
    // }
    //
    // private void collectPermutations(int[] nums, int start, List<Integer>
    // permutation,
    // List<List<Integer>> permutations) {
    //
    // if (permutation.size() == nums.length) {
    // permutations.add(permutation);
    // return;
    // }
    //
    // for (int i = 0; i <= permutation.size(); i++) {
    // List<Integer> newPermutation = new ArrayList<>(permutation);
    // newPermutation.add(i, nums[start]);
    // collectPermutations(nums, start + 1, newPermutation, permutations);
    // }
    // }
}
