package LeetCode;

/**
 * Created by 54359 on 2017/12/30.
 */
public class _92_Reverse_Linked_List_II {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {   //1 ≤ m ≤ n ≤ length of list.
        if (m == 1) {
            ListNode jilu = head;
            int count = 1;
            ListNode pre = null;
            ListNode next = null;
            ListNode cur = head;
            while (count <= n) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                count++;
            }
            jilu.next = cur;
            return pre;
        } else {
            ListNode jilu = head;
            int count = 1;
            while (++count != m) {
                jilu = jilu.next;
            }
            ListNode jilu_1 = jilu.next;
            ListNode pre = null;
            ListNode next = null;
            ListNode cur = jilu.next;
            while (count <= n) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                count++;
            }
            jilu.next = pre;
            jilu_1.next = cur;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ListNode head = reverseBetween(a1, 2, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
