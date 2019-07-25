/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val)
                fast = fast.next;
            if (slow.next == fast)// no duplicate
                slow = fast;
            else { // duplicate
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }
}
