package LeetCode;

import java.util.*;

/**
 * Created by 54359 on 2017/8/19.
 */
public class _102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            result.add(temp);
        }
        return result;
    }


//    //一次性写对，自己的思路是用一个list存储下一级的所有有效节点，然后依次循环
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result =new ArrayList<>();
//        if(root==null){
//            //result.add(new ArrayList<Integer>()); //这种错误貌似犯了好多次了，如果为空返回的应该是【】，不是【【】】
//            return result;
//        }
//        List<TreeNode> list = new ArrayList<>();
//        list.add(root);
//        xunhuan(result,list);
//        return result;
//    }
//    public void xunhuan(List<List<Integer>> result,List<TreeNode> list){
//        if(list.size()==0) return;
//        List<Integer> vallist=new ArrayList<>();
//        List<TreeNode> treeNodeList=new ArrayList<>();
//        for(TreeNode treeNode : list){
//            vallist.add(treeNode.val);
//            if(treeNode.left!=null) treeNodeList.add(treeNode.left);
//            if(treeNode.right!=null) treeNodeList.add(treeNode.right);
//        }
//        result.add(vallist);
//        xunhuan(result,treeNodeList);
//    }

    /*  这种思路要记住，用一个队列queue，把每一行的有效元素入队，然后用完一个把这个出队，把下一行的有效节点入队
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(root == null) return wrapList;
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);   //peek       返回队列头部的元素
                if(queue.peek().right != null) queue.offer(queue.peek().right); //offer       添加一个元素并返回true
                subList.add(queue.poll().val);  //poll         移除并返问队列头部的元素
            }
            wrapList.add(subList);
        }
        return wrapList;
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
