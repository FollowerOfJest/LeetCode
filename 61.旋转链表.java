/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        int count = 1;
        ListNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        ListNode last = temp;
        last.next = head;
        temp = head;
        k = k % count;
        k = count - k;
        count = 1;
        while (count != k) {
            temp = temp.next;
            count++;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }
}
