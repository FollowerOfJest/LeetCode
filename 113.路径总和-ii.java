
/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), root, sum);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {
        if (root == null)
            return;
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(list));
        } else {
            helper(result, list, root.left, sum - root.val);
            helper(result, list, root.right, sum - root.val);
        }
        list.remove(list.size() - 1);
    }

    //这个不对 ，可以想象根节点左边两个，右边1个，跟+右满足，但左边只会删掉叶子的val
    //路径上的val还保存，没法删掉,
    public List<List<Integer>> pathSum_2(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> intStack = new Stack<>();
        if (root == null)
            return result;
        nodeStack.add(root);
        intStack.add(sum);
        while(!nodeStack.isEmpty()){
            root=nodeStack.pop();
            int curSum=intStack.pop();
            list.add(root.val);
            
            if(root.left==null && root.right==null){
                if(curSum==root.val){
                    result.add(new ArrayList(list));
                }
                list.remove(list.size()-1);
            }
            if(root.left!=null){
                nodeStack.add(root.left);
                intStack.add(sum-curSum);
            }
            if(root.right!=null){
                nodeStack.add(root.right);
                intStack.add(sum-curSum);
            }

        }

        return result;
    }
}
