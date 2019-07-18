package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54359 on 2017/7/1.
 */
public class _54_Spiral_Matrix {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) return result;
        int row = matrix.length;
        if (row == 0) return result;
        if (matrix[0] == null) return result;
        int col = matrix[0].length;
        if (col == 0) return result;

        int row_begin = 0, row_end = row - 1;
        int col_begin = 0, col_end = col - 1;
        while (row_begin <= row_end && col_begin <= col_end) {
            for (int i = col_begin; i <= col_end; i++) {
                result.add(matrix[row_begin][i]);
            }
            row_begin++;
            for (int i = row_begin; i <= row_end; i++) {
                result.add(matrix[i][col_end]);
            }
            col_end--;
            if (row_begin <= row_end) {
                for (int i = col_end; i >= col_begin; i--) {
                    result.add(matrix[row_end][i]);
                }
            }
            row_end--;
            if (col_begin <= col_end) {
                for (int i = row_end; i >= row_begin; i--) {
                    result.add(matrix[i][col_begin]);
                }
            }
            col_begin++;
        }

        return result;
    }

    //一圈一圈的循环
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        int hang=matrix.length;
        if(hang==0) return result;
        int lie=matrix[0].length;
        recursion(result,matrix,0,hang-1,0,lie-1);
        return result;
    }

    public void recursion(List<Integer> result,int[][] matrix,int hang_begin,int hang_end,int lie_begin, int lie_end){
        if(hang_begin<=hang_end && lie_begin<=lie_end){
            int index_hang=hang_begin;
            int index_lie=lie_begin;
            if(hang_begin==hang_end){
                if(lie_begin==lie_end){
                    result.add(matrix[index_hang][lie_begin]);
                }else {
                    for(;index_lie<=lie_end;index_lie++){
                        result.add(matrix[index_hang][index_lie]);
                    }
                }
            }else {
                if(lie_begin==lie_end){
                    for(;index_hang<=hang_end;index_hang++){
                        result.add(matrix[index_hang][index_lie]);
                    }
                }else {
                    for(;index_lie<lie_end;index_lie++){
                        result.add(matrix[index_hang][index_lie]);
                    }
                    for(;index_hang<hang_end;index_hang++){
                        result.add(matrix[index_hang][index_lie]);
                    }
                    for(;index_lie>lie_begin;index_lie--){
                        result.add(matrix[index_hang][index_lie]);
                    }
                    for(;index_hang>hang_begin;index_hang--){
                        result.add(matrix[index_hang][index_lie]);
                    }
                    recursion(result,matrix,hang_begin+1,hang_end-1,lie_begin+1,lie_end-1);
                }
            }
        }
    }
}
