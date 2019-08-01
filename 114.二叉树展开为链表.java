/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    private TreeNode pre;
    public void flatten_1(TreeNode root) {
        if(root == null) return;
        if(pre != null){
            pre.right = root;
            pre.left = null;
        }
        pre = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
    public void flatten(TreeNode root) {
        while (root != null) { 
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                } 
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }
    
    //这个是用先序遍历实现的，更容易理解一些
    public void flatten_3(TreeNode root) { 
        if (root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop(); 
            /***********修改的地方*************/
            if(pre!=null){
                pre.right = temp;
                pre.left = null;
            }
            /********************************/
            if (temp.right != null){
                s.push(temp.right);
            }
            if (temp.left != null){
                s.push(temp.left);
            } 
            /***********修改的地方*************/
            pre = temp;
            /********************************/
        }
    }
    
   
}

