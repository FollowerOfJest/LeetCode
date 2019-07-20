import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return result;

        int rbegin = 0, rend = matrix.length - 1;
        int cbegin = 0, cend = matrix[0].length - 1;
        while (rbegin <= rend && cbegin <= cend) {
            for (int c = cbegin; c <= cend; c++) {
                result.add(matrix[rbegin][c]);
            }
            for (int r = rbegin + 1; r <= rend; r++) {
                result.add(matrix[r][cend]);
            }
            //注意这里的判断条件
            if(cbegin<cend && rbegin<rend){
                //
                for (int c = cend - 1; c > cbegin; c--) {
                    result.add(matrix[rend][c]);
                }
                for (int r = rend ; r > rbegin; r--) {
                    result.add(matrix[r][cbegin]);
                }
            }
            rbegin++;
            rend--;
            cbegin++;
            cend--;
        }
        return result;
    }
}
