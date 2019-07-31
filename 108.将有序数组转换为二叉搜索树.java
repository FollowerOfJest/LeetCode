/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    public TreeNode recursion(int[] nums, int begin, int end) {
        if (begin <= end) {
            int mid = (begin + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = recursion(nums, begin, mid - 1);
            node.right = recursion(nums, mid + 1, end);
            return node;
        } else {
            return null;
        }
    }
}
/*
class Node{ // need another class to store multi information
        int low, up; // means the TreeNode covers [low, up], low and up are all index
        TreeNode t;
        Node(int l, int p, TreeNode node){
            low = l;
            up = p;
            t = node;
        }
    }
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0) return null;
        Stack<Node> stack = new Stack<Node>();
        // initialize
        TreeNode root = new TreeNode(num[(num.length-1)/2]);
        Node rootNode = new Node(0,num.length-1,root);
        stack.push(rootNode);
        // iteration
        while(!stack.isEmpty()){
            Node node = stack.pop();
            int middle = (node.low+node.up)/2; // cut half for [low, up]
            
            // [low, middle-1]
            if(middle-1 >= node.low){
                TreeNode leftnode = new TreeNode(num[(middle-1+node.low)/2]);
                node.t.left = leftnode;
                Node left = new Node(node.low, middle-1, leftnode);
                stack.push(left);
            }
            // [middle+1, up]
            if(middle+1 <= node.up){
                TreeNode rightnode = new TreeNode(num[(middle+1+node.up)/2]);
                node.t.right = rightnode;
                Node right = new Node(middle+1, node.up, rightnode);
                stack.push(right);
            }
        }
        return root;
    }
*/

