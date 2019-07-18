package LeetCode;

/**
 * Created by 54359 on 2017/8/14.
 */
public class _100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
//    //一次性写对！
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//
//        if (p == null && q == null) return true;
//        if (p != null && q != null && p.val == q.val) {
//            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        } else {
//            return false;
//        }
//
//        //return true;
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
