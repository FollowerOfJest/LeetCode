package LeetCode;

/**
 * Created by 54359 on 2017/12/18.
 */
public class _28_Implement_strStr {
    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);  //就是实现这个
        int len1 = haystack.length(), len2 = needle.length();
        if (len2 > len1) return -1;
        if (len2 == 0) return 0;    //如果是“”要注意这种情况
        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.substring(i, i + len2).equals(needle))
                return i;
        }
        return -1;
    }
}
