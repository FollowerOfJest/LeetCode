package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 54359 on 2018/1/12.
 */
public class _47_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums); // 因为会有重复的，所以sort之后，重复的就在一起了
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) { // 如果放入的元素个数到了，那么就说明找到一种组合
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 用过了就continue
            if (used[i])
                continue;
            // 之后再判断之前有没有相同的， 相同的没有用过就跳过。只有相同的用过了才能使用，这样才不会产生重复
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
                continue; // 考虑重复的就可跳过，最后一个条件，考虑下1112的情况
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
