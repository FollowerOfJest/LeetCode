package LeetCode;

/**
 * Created by 54359 on 2017/12/27.
 */
public class _61_Rotate_List {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        k = k % length;
        k = length - k;
        ListNode last = temp;
        last.next = head;
        temp = head;
        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}
