/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int hang = obstacleGrid.length;
        int lie = obstacleGrid[0].length;
        int arr[][] = new int[hang][lie];
        for (int i = 0; i < lie; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            arr[0][i] = 1;
        }
        for (int i = 0; i < hang; i++) {
            if (obstacleGrid[i][0] == 1)
                break;
            arr[i][0] = 1;
        }
        for (int i = 1; i < hang; i++) {
            for (int j = 1; j < lie; j++) {
                if(obstacleGrid[i][j]==1){
                    arr[i][j]=0;
                }else{
                    arr[i][j]=arr[i-1][j]+arr[i][j-1];
                }
            }
        }
        return arr[hang-1][lie-1];
    }
}
