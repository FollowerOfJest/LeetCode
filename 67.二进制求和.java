/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder("");
        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        int indexa = charsa.length - 1, indexb = charsb.length - 1;
        int ain, bin, cin = 0;
        while (indexa > -1 || indexb > -1 || cin == 1) {
            ain = indexa > -1 ? charsa[indexa--] - '0' : 0; //记住这种写法
            bin = indexb > -1 ? charsb[indexb--] - '0' : 0; 
            if (ain + bin + cin >= 2) {
                result.append(ain + bin + cin - 2);
                cin = 1;
            } else {
                result.append(ain + bin + cin);
                cin = 0;
            }
        }
        return result.reverse().toString();
    }
}
