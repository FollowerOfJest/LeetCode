/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum_1(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.left==null && root.right==null){
            if(sum==root.val)
                return true;
            return false;
        }
        if(root.left==null)
            return hasPathSum(root.right, sum-root.val);
        if(root.right==null)
            return hasPathSum(root.left, sum-root.val);
        return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
        
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
          return false;
    
        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();
        node_stack.add(root);
        sum_stack.add(sum);
    
        TreeNode node;
        int curr_sum;
        while ( !node_stack.isEmpty() ) {
          node = node_stack.pollLast();
          curr_sum = sum_stack.pollLast();
          if ((node.right == null) && (node.left == null) && (curr_sum == node.val))
            return true;
    
          if (node.right != null) {
            node_stack.add(node.right);
            sum_stack.add(curr_sum - node.val);
          }
          if (node.left != null) {
            node_stack.add(node.left);
            sum_stack.add(curr_sum - node.val);
          }
        }
        return false;
      }
    

}

