/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */
class Solution {
    public int minPathSum(int[][] grid) {
        int hang = grid.length;
        int lie = grid[0].length;
        int[][] arr = new int[hang][lie];
        arr[0][0] = grid[0][0];
        for (int i = 1; i < lie; i++) {
            arr[0][i] = arr[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < hang; i++) {
            arr[i][0] = arr[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < hang; i++) {
            for (int j = 1; j < lie; j++) {
                arr[i][j] = grid[i][j] + Math.min(arr[i - 1][j], arr[i][j - 1]);
            }
        }
        return arr[hang - 1][lie - 1];
    }
}
