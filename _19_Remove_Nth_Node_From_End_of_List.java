package LeetCode;

/**
 * Created by 54359 on 2017/12/18.
 */
public class _19_Remove_Nth_Node_From_End_of_List {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;

    }

    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        if (len == n) {
            head = head.next;
            return head;
        }
        int index = 1;
        temp = head;
        while (index != len - n) {
            temp = temp.next;
            index++;
        }
        temp.next = temp.next.next;
        return head;
    }

}
