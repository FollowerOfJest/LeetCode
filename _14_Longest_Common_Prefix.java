package LeetCode;

/**
 * Created by 54359 on 2017/12/17.
 */
public class _14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String result=strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result)!=0){ //开始写成 result.indexof(strs[i])!=0，这样子的话，面对"" "aa"的情况会报错，应该是不断减小的值放在后边
                result=result.substring(0,result.length()-1);
            }
        }

        return result;
    }

    
    
}
