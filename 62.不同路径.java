/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] = arr[j - 1] + arr[j];
            }
        }
        return arr[n - 1];
    }
}
