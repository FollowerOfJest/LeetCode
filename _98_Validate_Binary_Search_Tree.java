package LeetCode;

/**
 * Created by 54359 on 2017/8/17.
 */
public class _98_Validate_Binary_Search_Tree {
    //想了很久，两次写对。
    //最底下是最开始的思路，写着写着发现代码都是一样的。。。
    //就是考虑清楚左边和右边，左边和右边的时候分别对应要比较的最大值和最小值是不一样的
    //代码应该还是可以继续简化的。先不简化了
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left==null &&root.right==null) return true;
        if(root.left==null && root.right.val>root.val) return recursion(root.right,root.val,Long.MAX_VALUE);
        if(root.left==null && root.right.val<=root.val) return false;
        if(root.right==null && root.left.val<root.val) return recursion(root.left,Long.MIN_VALUE,root.val);
        if(root.right==null && root.left.val>=root.val) return false;
        if(root.left.val>root.val || root.right.val<root.val) return false;
        else return recursion(root.left,Long.MIN_VALUE,root.val) && recursion(root.right,root.val,Long.MAX_VALUE);
    }

    public boolean recursion(TreeNode root,long min,long max){
        if(root.left==null && root.right==null) return true;
        if(root.left==null){
            if(root.right.val>root.val && root.right.val<max){
                return recursion(root.right,root.val,max);
            }else {
                return false;
            }
        }
        if(root.right==null){
            if(root.left.val< root.val && root.left.val>min){
                return recursion(root.left,min,root.val);
            }else{
                return false;
            }
        }
        if(root.right.val>root.val && root.right.val<max && root.left.val< root.val && root.left.val>min){
            return recursion(root.right,root.val,max)&&recursion(root.left,min,root.val);
        }
        return false;
    }


    /*
    public boolean recursion_left_left(TreeNode root,int min,int max){
        if(root.left==null && root.right==null) return true;
        if(root.left==null){
            if(root.right.val>root.val && root.right.val<max){
                return recursion_left_right(root.right,root.val,max);
            }else {
                return false;
            }
        }
        if(root.right==null){
            if(root.left.val<root.val && root.left.val>min){
                return recursion_right_left(root.left,min,root.val);
            }else {
                return false;
            }
        }
        if(root.left.val<root.val && root.left.val>min && root.right.val>root.val && root.right.val <max){
            return recursion_left_right(root.right,root.val,max)&&recursion_right_left(root.left,min,root.val);
        }
        return false;
    }
    public boolean recursion_left_right(TreeNode root,int min,int max){
        if(root.left==null && root.right==null) return true;
        if(root.left==null){
            if(root.right.val>root.val && root.right.val<max){
                return recursion_right_right(root.right,root.val,max);
            }else {
                return false;
            }
        }
        if(root.right==null){
            if(root.left.val<root.val&& root.left.val>min){
                return recursion_right_left(root.left,min,root.val);
            }else {
                return false;
            }
        }
        if(root.left.val<root.val && root.left.val>min && root.right.val>root.val && root.right.val<max){
            return recursion_right_right(root.right,root.val,max)&&recursion_right_left(root.left,min,root.val);
        }
        return false;
    }
    public boolean recursion_right_right(TreeNode root,int min,int max){
        if(root.left==null && root.right==null) return true;
        if(root.left==null){
            if(root.right.val>root.val && root.right.val<max){
                return recursion_right_right(root.right,root.val,max);
            }else{
                return false;
            }
        }
        if(root.right==null){
            if(root.left.val<root.val && root.left.val >min){
                return recursion_right_left(root.left,min,root.val);
            }else {
                return false;
            }
        }
        if(root.left.val<root.val && root.left.val>min && root.right.val>root.val && root.right.val<max){
            return recursion_right_right(root.right,root.val,max)&&recursion_right_left(root.left,min,root.val);
        }
        return false;
    }
    public boolean recursion_right_left(TreeNode root,int min,int max){
        if(root.left==null && root.right==null) return true;
        if(root.left==null){
            if(root.right.val>root.val && root.right.val<max){
                return recursion_left_right(root.right,root.val,max);
            }else{
                return false;
            }
        }
        if(root.right==null){
            if(root.left.val<root.val && root.left.val>min){
                return recursion_left_left(root.left,min,root.val);
            }else {
                return false;
            }
        }
        if(root.left.val<root.val && root.left.val>min && root.right.val>root.val && root.right.val<max){
            return recursion_left_right(root.right,root.val,max)&&recursion_left_left(root.left,min,root.val);
        }
        return false;
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
