package LeetCode;

/**
 * Created by 54359 on 2017/10/3.
 */
public class _83_Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            if (temp.next != null && temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }


    //一次性正确
    public ListNode deleteDuplicates_1(ListNode head) {
        if (head == null) return null;
        recursion(head);
        return head;
    }

    private void recursion(ListNode head) {
        if (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
                recursion(head);
            } else {
                recursion(head.next);
            }
        }
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
