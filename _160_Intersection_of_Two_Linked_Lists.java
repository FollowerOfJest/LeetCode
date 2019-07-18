package LeetCode;

/*
  Created by 54359 on 2017/10/12.
*/
public class _160_Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            if (tempA == null) tempA = headB;
            else tempA = tempA.next;
            if (tempB == null) tempB = headA;
            else tempB = tempB.next;
        }
        return tempA;
    }

//    //自己写的蠢方法，要看网上的方法
//    //自己的思路是先看两个的长短，然后先对其，对其之后在一个一个往下看有没有相同的
//    //网上的方法好，很方便的实现了对其，然后一个一个找。
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int la=length(headA),lb=length(headB);
//        ListNode tempa=headA,tempb=headB;
//        if(la==0 || lb==0) return null;
//        if(la>lb){
//            while(la!=lb){
//                la--;
//                tempa=tempa.next;
//            }
//        }else {
//            while (la!=lb){
//                lb--;
//                tempb=tempb.next;
//            }
//        }
//        while (tempa!=tempb){
//            tempa=tempa.next;
//            tempb=tempb.next;
//        }
//        return tempa;
//
//    }
//    public int length(ListNode node){
//        if (node==null) return 0;
//        int temp=1;
//        ListNode tempnode=node;
//        while (tempnode.next!=null){
//            tempnode=tempnode.next;
//            temp++;
//        }
//        return temp;
//    }

    /*  //他这种方法，如果两边不一样长，那么第一轮遍历之后，这样就能实现对其，然后一个一个找。
        //所以这道题貌似都是对其怎么弄的问题，显然这种方法好
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
            if(headA == null || headB == null) return null;

            ListNode a = headA;
            ListNode b = headB;

            //if a & b have different len, then we will stop the loop after second iteration
            while( a != b){
                //for the end of first iteration, we just reset the pointer to the head of another linkedlist
                a = a == null? headB : a.next;
                b = b == null? headA : b.next;
            }

            return a;
        }
    * */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
