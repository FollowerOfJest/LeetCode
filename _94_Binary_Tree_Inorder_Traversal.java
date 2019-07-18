package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54359 on 2017/8/17.
 */
public class _94_Binary_Tree_Inorder_Traversal {
    //一次性写对,中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        recursion(result, root);
        return result;
    }

    public void recursion(List<Integer> result, TreeNode root) {
        if(root.left!=null) recursion(result,root.left);
        result.add(root.val);
        if (root.right != null) recursion(result, root.right);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
