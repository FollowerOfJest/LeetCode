/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rbegin = 0, rend = n - 1;
        int cbegin = 0, cend = n - 1;
        int count = 1;
        while (rbegin < rend && cbegin < cend) {
            for (int c = cbegin; c <= cend - 1; c++) {
                result[rbegin][c] = count++;
            }
            for (int r = rbegin; r <= rend - 1; r++) {
                result[r][cend] = count++;
            }
            for (int c = cend; c >= cbegin + 1; c--) {
                result[rend][c] = count++;
            }
            for (int r = rend; r >= rbegin + 1; r--) {
                result[r][cbegin] = count++;
            }
            rbegin++;
            rend--;
            cbegin++;
            cend--;
        }
        if (rbegin == rend) {
            result[rbegin][cbegin] = count;
        }
        return result;
    }
}
