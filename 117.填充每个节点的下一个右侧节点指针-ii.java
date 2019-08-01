/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect_1(Node root) {
        //自顶向上递归
        if(root == null) return null;
        //构建当前节点的左节点
        if(root.left != null){
            //1.如果root有左节点和右节点，则左节点的Next为右节点
            if(root.right != null) root.left.next = root.right;
            //2.如果root右节点为Null，则查找父节点的兄弟节点的最左边子元素
            else root.left.next = findLeftChild(root);
        }
        //构建当前节点的右节点
        if(root.right != null)
            //如果root右节点不为Null，则next为父节点的兄弟节点的最左边子元素
            root.right.next = findLeftChild(root);
        //递归
        //一定要先构建右子树，再构建左子树，因为寻找父节点的
        //兄弟节点是从左到右遍历的，如果右子树未构建好就遍历，则会出错
        connect(root.right);
        connect(root.left);
        
        return root;
    }
    
    private Node findLeftChild(Node root){
        if(root.next == null) return null;
        while(root.next != null){
            if(root.next.left != null) return root.next.left;
            if(root.next.right != null) return root.next.right;
            root = root.next;
        }
        return null;
    }


    public Node connect(Node root) {
        Node cur = root;//当前父节点
        Node head = null;//每一行的最左边的节点
        Node tail = null;//每一行最右边的节点
        //套了两个cur!=null
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (head == null) {
                        head = cur.left;
                        tail = head;
                    } else {
                        tail.next = cur.left;
                        tail = tail.next;
                    }
                }
                if (cur.right != null) {
                    if (head == null) {
                        head = cur.right;
                        tail = head;
                    } else {
                        tail.next = cur.right;
                        tail = tail.next;
                    }
                }
                cur = cur.next;
            }
            cur = head;//更新，把cur更新为下一行的最左边的节点
            head = null;
            tail = null;
        }
        return root;
    }

}

