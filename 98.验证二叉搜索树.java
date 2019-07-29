/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST_1(TreeNode root) {
        Stack<TreeNode> stack=new Stack();
        TreeNode cur=root;
        boolean firsttime=true;
        int value=0;
        while (!stack.isEmpty()|| cur!=null) {
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if(firsttime){
                value=cur.val;
                firsttime=false;
            }else{
                if(value>=cur.val)
                    return false;
                value=cur.val;
            }
            cur=cur.right;
        }
        return true;
    }
    
    public boolean isValidBST(TreeNode root){
        Stack<TreeNode> stack=new Stack();
        TreeNode cur=root;
        //这里要加（long）
        long prevalue=(long)Integer.MIN_VALUE-1;
        while(!stack.isEmpty()||cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if(prevalue>=cur.val)
                return false;
            prevalue = cur.val;
            cur=cur.right;
        }
        return true;
    }
}
