import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
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
    // 不是常数的空间，使用了额外的queue
    public Node connect_1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return root;
        queue.add(root);
        Node pre;
        Node cur;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pre = null;
            cur = null;
            while (size-- != 0) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
                if (pre != null) {
                    pre.next = cur;
                    pre = cur;
                } else {
                    pre = cur;
                }

            }
        }
        return root;
    }
    //还是挺好理解的
    public Node connect(Node root) {
        if (root == null)
            return null;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;

    }
    //
    public Node connect_3(Node root) {
        Node pre = root;
        while (pre != null) {
            Node cur = pre;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }
}
