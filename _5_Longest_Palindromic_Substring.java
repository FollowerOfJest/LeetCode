package LeetCode;

import java.util.*;

public class _5_Longest_Palindromic_Substring {
    //中心扩展法，就是用暴力去一个一个试。aba和abba这两种情况
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    
    public String longestPalindrome_s(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        boolean[][] dp = new boolean[len][len];
        int longestPalindrome = 1;

        String longestPalindromeStr = s.substring(0, 1);

        // 如果 d[j,i] 为真，那么 dp[j+1,i-1] 也一定为真
        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                // 注意 i <= j + 2 || dp[j + 1][i - 1] 这种写法的技巧
                //这里是因为一开始都是false，符合上边的情况的时候才能设置为true，如a是true，aa是true，aba是true
                //还有根据dp[j+1][i-1]判断是不是true
                if (s.charAt(i) == s.charAt(j) && (i <= j + 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > longestPalindrome) {
                        longestPalindrome = i - j + 1;
                        longestPalindromeStr = s.substring(j, i + 1);
                    }
                }
           }
        }
        return longestPalindromeStr;
    }


}