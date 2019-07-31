import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null)
            return null;
        HashMap<Integer,Integer> map=new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    //嗯，还是好好想想left和right的逻辑
    public TreeNode helper(int[] inorder, int instart, int inend, int[] posorder, int posstart, int posend,HashMap<Integer,Integer> map) {
        if (instart > inend || posstart > posend)
            return null;
        TreeNode root=new TreeNode(posorder[posend]);
        int inIndex=map.get(posorder[posend]);
        root.left=helper(inorder, instart, inIndex-1, posorder, posstart, posstart+inIndex-instart-1, map);
        root.right=helper(inorder, inIndex+1, inend, posorder, posstart+inIndex-instart, posend-1, map);

        return root;
    }
}
