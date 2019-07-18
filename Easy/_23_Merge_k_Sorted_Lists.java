package LeetCode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by 54359 on 2017/12/26.
 */
public class _23_Merge_k_Sorted_Lists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //自己写的方法对了，但是超时
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = null;
        int index_min = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (temp == null) {
                    temp = lists[i];
                    index_min=i;
                } else {
                    if (lists[i].val < temp.val) {
                        index_min = i;
                        temp = lists[i];
                    }
                }
            }
        }
        if (temp == null) return null;
        lists[index_min] = lists[index_min].next;
        temp.next = mergeKLists(lists);
        return temp;
    }
    //方法一，使用21题中合并两个链表的方法，每次两个两个的合并
    public static ListNode mergeKLists_1(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return mergeTwoLists(l1,l2);
        }else
            return null;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val<=l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }


    public static ListNode mergeKLists_2(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        a1.next = a2;
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        b1.next = b2;
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(5);
        c1.next = c2;
        ListNode[] list = {a1, b1, c1};
        ListNode temp = mergeKLists_2(list);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
