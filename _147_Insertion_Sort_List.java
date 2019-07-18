package LeetCode;

/**
 * Created by 54359 on 2017/12/28.
 */
public class _147_Insertion_Sort_List {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode last = head;
        while (temp != null) {
            if (temp.val <= head.val) {
                last.next = temp.next;
                temp.next = head;
                head = temp;
                temp = last.next;
            } else {
                if (temp.val >= last.val) { //2 这里是第二次写的，最开始没有，更快了，因为最好先跟last节点进行一下比较，如果大于last，那就不用在循环了
                    last = temp;
                    temp = temp.next;
                }else {
                    ListNode begin = head;
                    while (begin.next.val < temp.val) {
                        begin = begin.next;
                    }
                    last.next = temp.next;
                    temp.next = begin.next;
                    begin.next = temp;
                    temp = last.next;
//                    if (begin.next != temp) {   //1 这里的判断很关键,这里是第一次写的
//                        last.next = temp.next;
//                        temp.next = begin.next;
//                        begin.next = temp;
//                        temp = last.next;
//                    } else {
//                        last = temp;
//                        temp = temp.next;
//                    }
                }

            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        a1.next = a2;
        ListNode a3 = new ListNode(3);
        a2.next = a3;
        ListNode a4 = new ListNode(2);
        a3.next = a4;
        ListNode a5 = new ListNode(1);
        a4.next = a5;

        ListNode result = insertionSortList(a1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
