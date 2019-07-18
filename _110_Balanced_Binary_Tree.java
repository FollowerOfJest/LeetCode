package LeetCode;


import java.util.Map;

/**
 * Created by 54359 on 2017/8/16.
 */
public class _110_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        if (left == -1) return -1;
        int right = height(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;

    }

//    //自己写的，感觉效率有点低，两次递归
//    public boolean isBalanced(TreeNode root) {
//        if(root==null) return true;
//        if(Math.abs(Depth(root.left)-Depth(root.right))>1) return false;
//        else {
//            return isBalanced(root.left)&&isBalanced(root.right);
//        }
//    }
//
//    public int Depth(TreeNode root){
//        if (root == null) return 0;
//        return 1 + Math.max(Depth(root.left), Depth(root.right));
//    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

/*这个方法，在maxDepth中，每一部都判断是否是平衡二叉树
public class Solution {
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1)
            result = false;
        return 1 + Math.max(l, r);
    }
}
*/
/*这个同上，但是没有用公共变量result
//这个方法最趋近于我自己写的，直接在判断depth的时候判断是否平衡
public boolean isBalanced(TreeNode root) {
    if(root==null){
        return true;
    }
    return height(root)!=-1;

}
public int height(TreeNode node){
    if(node==null){
        return 0;
    }
    int lH=height(node.left);
    if(lH==-1){
        return -1;
    }
    int rH=height(node.right);
    if(rH==-1){
        return -1;
    }
    //如果左右深度相差大于1，那么就给他一个-1，不是的话那么计算正确的深度
    if(lH-rH<-1 || lH-rH>1){
        return -1;
    }
    return Math.max(lH,rH)+1;
}
 */
