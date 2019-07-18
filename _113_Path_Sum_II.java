package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 54359 on 2017/12/22.
 */
public class _113_Path_Sum_II {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //这种方法感觉很慢，而且很占内存空间
    public List<List<Integer>> pathSum_1(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        recursion(result, root, sum, new ArrayList<>());
        return result;
    }

    public void recursion(List<List<Integer>> result, TreeNode root, int sum, List<Integer> list) {
        if (root == null) return;
        List<Integer> temp = new ArrayList<>(list);//
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                result.add(temp);
            }
            return;
        }
        recursion(result, root.left, sum - root.val, temp);
        recursion(result, root.right, sum - root.val, temp);
    }

    //网上的方法学习一下，想起了3sum中的写法
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result  = new LinkedList<List<Integer>>();
        List<Integer> currentResult  = new LinkedList<Integer>();
        pathSum(root,sum,currentResult,result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
                        List<List<Integer>> result) {

        if (root == null)
            return;
        currentResult.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
            return;
        } else {
            pathSum(root.left, sum - root.val, currentResult, result);
            pathSum(root.right, sum - root.val, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
    }
}
