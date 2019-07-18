package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 54359 on 2017/6/29.
 */
public class _39_Combination_Sum {
    //自己写的错了，这是抄的
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> temp, int candidates[], int target, int start){
        if(target > 0){
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                temp.add(candidates[i]);
                getResult(result, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
        else if(target == 0 ){
            result.add(new ArrayList<>(temp));
        }
    }

    /*阳
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
		List<List<Integer>> data = new ArrayList<>();
		helper(data, new ArrayList<Integer>(), candidates, target, 0);
		return data;
    }
    public void helper(List<List<Integer>> data, List<Integer> temp, int[] candidates, int target, int index) {
		for (int i = index; i < candidates.length; ++i) {
			if (target > candidates[i]) {
				List<Integer> next = new ArrayList<>(temp);
				next.add(candidates[i]);
				helper(data, next, candidates, target - candidates[i], i);
			} else if (target == candidates[i]) {
				List<Integer> next = new ArrayList<>(temp);
				next.add(candidates[i]);
				data.add(next);
				break;
			} else {
				break;
			}
		}
	}
    */

}
