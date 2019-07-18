package LeetCode;

/**
 * Created by 54359 on 2017/8/15.
 */
public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

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

//    // 每次找中间的数,先看的答案。
//    //用一个升序的数组构造平衡的二叉查找树。每次找中间的就是根节点，然后在剩下的前边找左节点，剩下的右边找右节点
//    public TreeNode sortedArrayToBST(int[] nums) {
//        return recursion(nums,0,nums.length-1);
//    }
//
//    public TreeNode recursion(int[] nums,int begin,int end){
//        if(begin<=end){ //是《=
//            int mid=(begin+end)/2;
//            TreeNode root=new TreeNode(nums[mid]);
//            TreeNode leftchild=recursion(nums,begin,mid-1);
//            TreeNode rightchild=recursion(nums,mid+1,end);
//            root.left=leftchild;
//            root.right=rightchild;
//            return root;
//
//        }else {
//            return null;
//        }
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
