package LeetCode;

/**
 * Created by 54359 on 2017/8/14.
 */
public class _101_Symmetric_Tree {

    public boolean isSymmetric(TreeNode root) {
        return recursion(root, root);
    }

    public boolean recursion(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 != null && node2 != null && node1.val == node2.val) {
            return recursion(node1.left,node2.right) && recursion(node1.right,node2.left);
        } else {
            return false;
        }
    }

//    //一次通过
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        if (root.left == null && root.right == null) return true;
//        if (root.left != null && root.right != null && root.left.val == root.right.val) {
//            return recursion(root.left.left, root.right.right) && recursion(root.left.right, root.right.left);
//        } else {
//            return false;
//        }
//    }
//
//    public boolean recursion(TreeNode x, TreeNode y) {
//        if (x == null && y == null) return true;
//        if (x != null && y != null && x.val == y.val) {
//            return recursion(x.left, y.right) && recursion(x.right, y.left);
//        } else {
//            return false;
//        }
//    }

    /*  这是答案给的方法。这么写可以减少代码量
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
     */

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
