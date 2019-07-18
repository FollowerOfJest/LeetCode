package LeetCode;

import java.util.*;

public class _6_ZigZag_Conversion {
    public static String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        StringBuffer result = new StringBuffer();
        StringBuffer[] arr = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuffer();
        }
        Boolean isDown = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[count].append(s.charAt(i));
            //这里的向上向下，开始最后边的那个判断写错了，应该是向上或向下的状态保持不变
            isDown = count == 0 ? true : (count == numRows - 1 ? false : isDown);
            count = isDown ? count + 1 : count - 1;
        }
        for (int i = 0; i < numRows; i++) {
            result.append(arr[i]);
        }
        return result.toString();
    }

    //规律，每行元素的规律
    public String convert_s(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }



    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }
}