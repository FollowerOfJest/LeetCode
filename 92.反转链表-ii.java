/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        int count=1;
        ListNode cur=head;
        ListNode pre=dummy;
        ListNode nodem=null;
        while (count!=m) {
            cur=cur.next;
            pre=pre.next;
            count++;
        }
        nodem=cur;
        while(count!=n){
            cur=cur.next;
            count++;
        }
        pre.next=reverse(nodem,cur.next);
        return dummy.next;
    }

    public ListNode reverse(ListNode head,ListNode endNext){
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=endNext){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        head.next=endNext;
        return pre;
    }
}

