package LeetCode;

import java.util.*;

/**
 * Created by 54359 on 2017/8/14.
 */
public class _100_Same_Tree {
    public boolean isSameTree_1(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null)
            return false;
        if (q == null)
            return false;
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null)
            return true;
        // one of p and q is null
        if (q == null || p == null)
            return false;
        if (p.val != q.val)
            return false;
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (!check(p, q))
            return false;

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q))
                return false;
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left))
                    return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right))
                    return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }

    // //一次性写对！
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //
    // if (p == null && q == null) return true;
    // if (p != null && q != null && p.val == q.val) {
    // return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    // } else {
    // return false;
    // }
    //
    // //return true;
    // }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
