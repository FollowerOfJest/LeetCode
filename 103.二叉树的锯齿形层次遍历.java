import java.util.*;




/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList();
        if(root==null)
            return result;
        boolean isLeft2Right=true;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            while(size--!=0){
                if(isLeft2Right){
                    root=queue.removeFirst();
                    temp.add(root.val);
                    if(root.left!=null) queue.addLast(root.left);
                    if(root.right!=null) queue.addLast(root.right);
                }else{
                    root=queue.removeLast();
                    temp.add(root.val);
                    if(root.right!=null) queue.addFirst(root.right);
                    if(root.left!=null) queue.addFirst(root.left);
                }
            }
            isLeft2Right=!isLeft2Right;
            result.add(temp);
        }
        return result;

    }
}

