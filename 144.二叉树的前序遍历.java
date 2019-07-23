
/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        if (root != null)
            stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if(root.right!=null)
                stack.add(root.right);
            if(root.left!=null)
                stack.add(root.left);
        }
        return result;
    }
}
