/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        if(n<1)
            return new ArrayList();
        
        return recursion(1,n);
    }
    public List<TreeNode> recursion(int start,int end){
        List<TreeNode> list=new ArrayList();
        //==的情况是刚好那这个元素做父节点
        if(start>end){
            list.add(null);
            return list;
        }
        for (int value = start; value <= end; value++) {
            //所有可能的左节点
            List<TreeNode> left=recursion(start,value-1);
            //所有可能的右节点
            List<TreeNode> right=recursion(value+1,end);
            for(TreeNode lnode:left){
                for(TreeNode rnode:right){
                    TreeNode node=new TreeNode(value);
                    node.left=lnode;
                    node.right=rnode;
                    list.add(node);
                }
            }
        }
        return list;
    }
}

