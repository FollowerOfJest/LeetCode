package LeetCode;

import java.util.*;

public class _17 {

    //写的有点乱
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if(digits==null || digits.length()==0)
            return result;
        //                 2      3      4     5       6      7       8       9
        String[] arr = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        StringBuffer str = new StringBuffer();
        recursion(result, arr, 0, digits.length(), str,digits);
        return result;
    }
    //就是这个逻辑，234，按位置依次往后组合，当超过长度了，那么组合就拼起来了
    public static void recursion(List<String> list, String[] arr, int from, int to, StringBuffer str, String digits) {
        //这里是到位置了，该放结果了
        if (from == to) {
            list.add(str.toString());
            return;
        }
        int index = digits.charAt(from) - '2';
        //这里我用的StringBuffer，所以加字符之后在循环后还要删掉才能进入下一轮的位置
        for (int i = 0; i < arr[index].length(); i++) {
            str.append(arr[index].charAt(i));
            recursion(list, arr, from+1, to, str, digits);
            str.deleteCharAt(from);
        }
    }

    public static void main(String[] args) {
        List<String> list=letterCombinations("23");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}