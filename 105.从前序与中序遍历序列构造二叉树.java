import java.util.*;/*
                   * @lc app=leetcode.cn id=105 lang=java
                   *
                   * [105] 从前序与中序遍历序列构造二叉树
                   */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        if (preorder == null)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, 0, preorder.length - 1, map);
    }

    //这里的start和end应该是代表inorder的
    public TreeNode helper(int[] preorder, int[] inorder, int rootIndex, int start, int end,
            HashMap<Integer, Integer> map) {
        if (start > end)
            return null;
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int x = map.get(preorder[rootIndex]);
        root.left = helper(preorder, inorder, rootIndex + 1, start, x - 1, map);
        root.right = helper(preorder, inorder, rootIndex + 1 + x - start, x + 1, end, map);
        return root;
    }

    //
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length)
            return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh) {
        if (preLow > preHigh || inLow > inHigh)
            return null;
        TreeNode root = new TreeNode(preorder[preLow]);

        int inorderRoot = inLow;
        for (int i = inLow; i <= inHigh; i++) {
            if (inorder[i] == root.val) {
                inorderRoot = i;
                break;
            }
        }

        int leftTreeLen = inorderRoot - inLow;
        root.left = build(preorder, preLow + 1, preLow + leftTreeLen, inorder, inLow, inorderRoot - 1);
        root.right = build(preorder, preLow + leftTreeLen + 1, preHigh, inorder, inorderRoot + 1, preHigh);
        return root;
    }
}
