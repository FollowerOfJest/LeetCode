package LeetCode;

import java.util.Stack;

/**
 * Created by 54359 on 2017/10/12.
 */
public class _155_Min_Stack {
    private Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public _155_Min_Stack() {

    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    //使用链表的方法
//    class MinStack {
//        private Node head;
//
//        public void push(int x) {
//            if(head == null)
//                head = new Node(x, x);
//            else
//                head = new Node(x, Math.min(x, head.min), head);
//        }
//
//        public void pop() {
//            head = head.next;
//        }
//
//        public int top() {
//            return head.val;
//        }
//
//        public int getMin() {
//            return head.min;
//        }
//
//        private class Node {
//            int val;
//            int min;
//            Node next;
//
//            private Node(int val, int min) {
//                this(val, min, null);
//            }
//
//            private Node(int val, int min, Node next) {
//                this.val = val;
//                this.min = min;
//                this.next = next;
//            }
//        }
//    }



//    //网上抄的方法。。没动脑子。
//    //他是每次如果有新的最小值，那就把原先的最小值先存下，然后再存新的最小值
//    //这样pop之后，如果pop了最小值，那就在pop一次把次小值拿到
//    int min = Integer.MAX_VALUE;
//    Stack<Integer> stack = new Stack<Integer>();
//    public void push(int x) {
//        // only push the old minimum value when the current
//        // minimum value changes after pushing the new value x
//        if(x <= min){
//            stack.push(min);
//            min=x;
//        }
//        stack.push(x);
//    }
//
//    public void pop() {
//        // if pop operation could result in the changing of the current minimum value,
//        // pop twice and change the current minimum value to the last minimum value.
//        if(stack.pop() == min) min=stack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return min;
//    }

}
