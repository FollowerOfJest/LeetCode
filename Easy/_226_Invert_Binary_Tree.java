package LeetCode;

/**
 * Created by 54359 on 2017/8/21.
 */
public class _226_Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
//    //翻转二叉树,一次性写对，但写的代码有点冗余
//    public TreeNode invertTree(TreeNode root) {
//        if(root==null) return root;
//        recursion(root);
//        return root;
//    }
//    public void recursion(TreeNode root){
//        if(root.left==null && root.right==null) return;
//        if(root.left==null){
//            root.left=root.right;
//            root.right=null;
//            recursion(root.left);
//            return;
//        }
//        if(root.right==null){
//            root.right=root.left;
//            root.left=null;
//            recursion(root.right);
//            return;
//        }
//        TreeNode temp=root.left;
//        root.left=root.right;
//        root.right=temp;
//        recursion(root.left);
//        recursion(root.right);
//        return;
//    }
//    /*
//    public TreeNode invertTree(TreeNode root) {
//        if(root == null) return null;
//        TreeNode tmp = root.left;
//        root.left = invertTree(root.right);
//        root.right = invertTree(tmp);
//        return root;
//    }
//     */

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
