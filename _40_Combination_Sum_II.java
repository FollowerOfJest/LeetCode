package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 54359 on 2017/6/30.
 */
public class _40_Combination_Sum_II {

    // 代码与39相似，参考15中的重复跳过。
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        recursion(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void recursion(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                //这里的跳过规则同15题中的跳跃规则
                if (i > start && candidates[i] == candidates[i - 1])
                    continue; // 这里负责跳过重复的
                cur.add(candidates[i]);
                recursion(result, cur, candidates, target - candidates[i], i + 1); // 因为不能重复找数字了，所以得去下一个位置
                cur.remove(cur.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<>(cur));
        }
    }
}
