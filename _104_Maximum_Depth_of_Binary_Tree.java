package LeetCode;

/**
 * Created by 54359 on 2017/8/14.
 */
public class _104_Maximum_Depth_of_Binary_Tree {

    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
//    //一次性写对，树的最大深度
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
