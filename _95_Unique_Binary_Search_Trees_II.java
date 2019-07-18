package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54359 on 2017/8/17.
 */
public class _95_Unique_Binary_Search_Trees_II {
    /*
    //自己的思路对了，但是没写出来。
    //网上的方法，在下边的递归中，依然以list作为中间量
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<TreeNode>();
        return recursion(1,n);
    }
    public List<TreeNode> recursion(int begin,int end){
        List<TreeNode> result=new ArrayList<>();
        if(begin>end){
            result.add(null);
            return result;
        }
        for(int i=begin;i<=end;i++){
            List<TreeNode> leftlist=recursion(begin,i-1);
            List<TreeNode> rightlist=recursion(i+1,end);
            for(TreeNode left:leftlist){
                for (TreeNode right:rightlist){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    result.add(root);
                }
            }
        }
        return result;
    }
    */
    //这个方法貌似思路跟96有点像，又是先来个数组，然后一步一步来
    public  List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new ArrayList[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }
        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j+1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private  TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
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
