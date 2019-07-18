package LeetCode;

import java.util.*;

public class _24 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next=head.next;
        head.next=swapPairs(head.next.next);
        next.next=head;
        return next;
    }

    public ListNode swapPairs_s(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;

    }

}