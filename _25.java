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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1)
            return head;
        //在前边加一个伪节点
        ListNode dummy = new ListNode(0);
        //pre节点最开始指向dummy，0 12345 k=2，那么pre的值为0，1，3，主要作用是记录翻转后的最后一个值，然后用pre.next=next连接后边
        ListNode pre = dummy;
        //后续节点，用他来做边界判断
        ListNode next = head;
        //建立联系
        dummy.next = head;
        //计数
        int count = 0;

        ListNode temp = null;
        while (true) {
            next = next.next;
            count++;//这个count++的位置搞错了好几遍
            //next==null有两种情况，一个是刚好刚凑够了k个，或者不够
            if (next == null) {
                if (count == k) {
                    temp = pre.next;
                    pre.next = reverse(pre.next, next);
                    pre = temp;
                    pre.next=next;
                } 
                break;
            }

            if (count == k) {
                count = 0;
                //在这里加以说明
                //记录temp，pre之后的节点就是下一次的pre节点
                temp = pre.next;
                //翻转k个，以next为界，reverse返回的是头节点，pre.next=函数的结果
                pre.next = reverse(pre.next, next);
                //pre更新为reverse完最后的节点
                pre = temp;
                //更新后的pre和next连接
                pre.next=next;
            }
            
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode begin, ListNode newbegin) {
        ListNode pre = null;
        ListNode next = null;
        while (begin != newbegin) {
            next = begin.next;
            begin.next = pre;
            pre = begin;
            begin = next;
        }
        return pre;
    }
}