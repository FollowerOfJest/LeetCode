package LeetCode;

/**
 * Created by 54359 on 2017/8/16.
 */
public class _112_Path_Sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val == sum) return true;
            else return false;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

//    //一次性写对
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) return false;
//        if (root.left == null && root.right == null) {
//            if (sum - root.val == 0) return true;
//            else return false;
//        }
//        if (root.left == null) return hasPathSum(root.right, sum - root.val);
//        if (root.right == null) return hasPathSum(root.left, sum - root.val);
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//
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
