package LeetCode;

/**
 * Created by 54359 on 2017/12/18.
 */
public class _2_Add_Two_Numbers {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int value = l1.val + l2.val;
        int jinwei = value / 10;
        value = value % 10;
        ListNode node = new ListNode(value);
        if (l1.next == null && l2.next == null) {
            if (jinwei == 1) node.next = new ListNode(1);
            else node.next = null;
        } else if (l1.next == null && l2.next != null) {
            if (jinwei == 1) {
                node.next = addTwoNumbers(new ListNode(1), l2.next);
            } else {
                node.next = addTwoNumbers(null, l2.next);
            }
        } else if (l1.next != null && l2.next == null) {
            if (jinwei == 1) {
                node.next = addTwoNumbers(l1.next, new ListNode(1));
            } else {
                node.next = addTwoNumbers(l1.next, null);
            }
        } else {
            if (jinwei == 1) {
                l1.next.val++;
            }
            node.next = addTwoNumbers(l1.next, l2.next);
        }
        return node;
    }

    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

   
}
