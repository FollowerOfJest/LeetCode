package LeetCode;

import java.util.*;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                left = Math.max(left, map.get(temp) + 1);//想清楚这一步，如何更新left，这个left要保证left~i的区间没有重复
            }
            result = Math.max(result, i - left + 1);
            map.put(temp, i);
        }

        return result;
    }
}