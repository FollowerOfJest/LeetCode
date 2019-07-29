/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode node1, TreeNode node2) {
        if(node1==null &&node2==null)
            return true;
        if((node1==null && node2!=null)||(node1!=null&&node2==null))
            return false;
        if(node1.val!=node2.val)
            return false;
        return helper(node1.left,node2.right)&&helper(node1.right,node2.left);
    }

    public boolean isSymmetric_1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
    

}
