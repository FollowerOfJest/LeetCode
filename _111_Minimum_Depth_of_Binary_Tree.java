package LeetCode;

/**
 * Created by 54359 on 2017/8/16.
 */
public class _111_Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) return 1;
        if (root.left != null && root.right == null) return 1 + minDepth(root.left);
        if (root.left == null && root.right != null) return 1 + minDepth(root.right);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

//    //不能直接return那个1+。。。一定是到树叶的距离，直接来的话如果root少个儿子那他就只把根节点算进去，没算另一个分支了
//    public int minDepth(TreeNode root) {
//        if(root==null) return 0;
//        if(root.left==null && root.right==null) return 1;
//        if(root.right==null) return 1+minDepth(root.left);
//        if(root.left==null) return 1+minDepth(root.right);
//        return 1+Math.min(minDepth(root.left),minDepth(root.right));
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
