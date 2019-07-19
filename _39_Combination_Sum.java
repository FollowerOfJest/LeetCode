package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 54359 on 2017/6/29.
 */
public class _39_Combination_Sum {
    //都是正数
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //先排序
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }
    //递归
    private void getResult(List<List<Integer>> result, List<Integer> temp, int candidates[], int target, int start){
        if(target > 0){ //只有剩余的值>=0才有意义，小于0说明不需要进一步判断了，因为数组已经排序了
            //这里基本就是考虑了所有的可能，从start开始一个一个试，+当前值 不+当前值，两种情况分别递归
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                temp.add(candidates[i]);
                //因为可以无限使用每个数字，所以start还是i
                getResult(result, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
        else if(target == 0 ){
            //这里记得要用这种方式，因为temp是引用对象，直接放的话是引用不行的
            result.add(new ArrayList<>(temp));
        }
    }

    

}
