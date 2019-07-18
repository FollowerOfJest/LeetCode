package LeetCode;

/**
 * Created by 54359 on 2017/12/25.
 */
public class _125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        char[] array = s.toLowerCase().toCharArray();
        int lo = 0;
        int hi = array.length - 1;
        while (lo < hi) {
            while (lo < hi && (int) array[lo] < 48 || (int) array[lo] > 122 || ((int) array[lo] > 57 && (int) array[lo] < 97)) {
                lo++;
            }
            while (lo < hi && (int) array[hi] < 48 || (int) array[hi] > 122 || ((int) array[hi] > 57 && (int) array[hi] < 97)) {
                hi--;
            }
            if (array[lo] != array[hi]) return false;
            lo++;
            hi--;
        }
        return true;
    }
}
