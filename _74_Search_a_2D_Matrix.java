package LeetCode;

/**
 * Created by 54359 on 2017/7/10.
 */
public class _74_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int hang=matrix.length;
        if(hang==0) return  false;
        int lie=matrix[0].length;
        if(lie==0) return false;
        int hang_begin=0,hang_end=hang-1;
        int lie_begin=0,lie_end=lie-1;
        int hang_mid;
        int lie_mid;

        while(hang_begin<=hang_end){
            hang_mid=(hang_begin+hang_end)/2;
            if(matrix[hang_mid][0]>target){
                hang_end=hang_mid-1;
            }else if(matrix[hang_mid][lie_end]<target){
                hang_begin=hang_mid+1;
            }else {
                while (lie_begin<=lie_end){
                    lie_mid=(lie_begin+lie_end)/2;
                    if(matrix[hang_mid][lie_mid]==target) return true;
                    else if(matrix[hang_mid][lie_mid]<target)   lie_begin=lie_mid+1;
                    else lie_end=lie_mid-1;
                }
            }
        }

        return false;
    }
}
