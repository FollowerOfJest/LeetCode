package LeetCode;

import java.util.Stack;

/**
 * Created by 54359 on 2017/12/17.
 */
public class _20_Valid_Parentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    stack.push(')');break;  //复习了switch-case，忘记写break一次
                case '[':
                    stack.push(']');break;
                case '{':
                    stack.push('}');break;
                default:
                    if (stack.isEmpty() || stack.pop() != chars[i])
                        return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
