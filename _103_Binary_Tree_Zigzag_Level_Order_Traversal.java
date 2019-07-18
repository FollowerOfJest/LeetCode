package LeetCode;

import java.util.*;

/**
 * Created by 54359 on 2017/8/19.
 */
public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {
    /*
    //一次性写对，思路同102,蛇形输出的话，就是在xunhuan那里要判断是从左向右还是从右向左，然后上一轮的list的节点顺序与这一轮的判断是相反的
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result =new ArrayList<>();
        if(root==null){
            return result;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        xunhuan(result,list,true);
        return result;
    }
    public void xunhuan(List<List<Integer>> result,List<TreeNode> list,boolean isLefttoRight){
        if(list.size()==0) return;
        List<Integer> vallist=new ArrayList<>();
        List<TreeNode> treeNodeList=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            TreeNode treeNode= list.get(i);
            vallist.add(treeNode.val);
            if(isLefttoRight){
                if(treeNode.left!=null) treeNodeList.add(treeNode.left);
                if(treeNode.right!=null) treeNodeList.add(treeNode.right);
            }else {
                if(treeNode.right!=null) treeNodeList.add(treeNode.right);
                if(treeNode.left!=null) treeNodeList.add(treeNode.left);
            }
        }
        result.add(vallist);
        xunhuan(result,treeNodeList,!isLefttoRight);
    }
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //用队列实现
        //其实每次存储都从左到右存储就好了，然后把相应的数值正序排列或者倒序排列就可以了
        List<List<Integer>> result =new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean isLeftToRight=true;
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> vallist=new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode treeNode=queue.poll();
                if(isLeftToRight){
                    vallist.add(treeNode.val);
                }else {
                    vallist.add(0,treeNode.val);
                }
                if(treeNode.left!=null) queue.offer(treeNode.left);
                if(treeNode.right!=null) queue.offer(treeNode.right);
            }
            result.add(vallist);
            isLeftToRight=!isLeftToRight;
        }
        return result;
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
