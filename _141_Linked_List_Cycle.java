package LeetCode;

/**
 * Created by 54359 on 2017/10/5.
 */
public class _141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null || head.next.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

//    //一快一慢，如果快的和慢的重逢了，那就说明有环路
//    public boolean hasCycle(ListNode head) {
//        ListNode fast=head,slow=head;
//        while(fast!=null&& fast.next!=null){
//            fast=fast.next.next;
//            slow=slow.next;
//            if(fast==slow) return true;
//        }
//        return false;
//    }
    //这种写一写明白了，让走过的点的next为自己，这样如果有环路回来的话就会有自己=自己.next，不过这样子会改变链表原有结构，不太好
//    public boolean hasCycle(ListNode head){
//        if(head == null || head.next == null) return false;
//        if(head.next == head) return true;
//        ListNode nextNode = head.next;
//        head.next = head;
//        boolean isCycle = hasCycle(nextNode);
//        return isCycle;
//    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
