package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54359 on 2017/12/26.
 */
public class _22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recursion(result, "", 0, 0, n);
        return result;
    }

    public void recursion(List<String> result, String s, int left, int right, int n) {
        if (s.length() == n * 2) {
            result.add(s);
            return;
        }
        //增加左括号的逻辑
        if (left < n) {
            recursion(result, s + "(", left + 1, right, n);
        }
        //增加右括号的逻辑
        if (right < left) {
            recursion(result, s + ")", left, right + 1, n);
        }
    }
}
