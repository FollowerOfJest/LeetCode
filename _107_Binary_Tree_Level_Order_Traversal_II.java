package LeetCode;

import java.util.*;

/**
 * Created by 54359 on 2017/8/21.
 */
public class _107_Binary_Tree_Level_Order_Traversal_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size != 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            result.add(0,temp);
        }
        return result;
    }

    /*思路同102，只不过最后结果从result.add(temp)变成了result.add(0,temp)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result =new ArrayList<>();
        if(root==null){
            //result.add(new ArrayList<Integer>()); //这种错误貌似犯了好多次了，如果为空返回的应该是【】，不是【【】】
            return result;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        xunhuan(result,list);
        return result;
    }
    public void xunhuan(List<List<Integer>> result,List<TreeNode> list){
        if(list.size()==0) return;
        List<Integer> vallist=new ArrayList<>();
        List<TreeNode> treeNodeList=new ArrayList<>();
        for(TreeNode treeNode : list){
            vallist.add(treeNode.val);
            if(treeNode.left!=null) treeNodeList.add(treeNode.left);
            if(treeNode.right!=null) treeNodeList.add(treeNode.right);
        }
        result.add(0,vallist);
        xunhuan(result,treeNodeList);
    }
    */
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
//        if(root == null) return wrapList;
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int levelNum = queue.size();
//            List<Integer> subList = new LinkedList<Integer>();
//            for(int i=0; i<levelNum; i++) {
//                if(queue.peek().left != null) queue.offer(queue.peek().left);   //peek       返回队列头部的元素
//                if(queue.peek().right != null) queue.offer(queue.peek().right); //offer       添加一个元素并返回true
//                subList.add(queue.poll().val);  //poll         移除并返问队列头部的元素
//            }
//            wrapList.add(0,subList);
//        }
//        return wrapList;
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
