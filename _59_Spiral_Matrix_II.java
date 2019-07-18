package LeetCode;

/**
 * Created by 54359 on 2017/7/3.
 */
public class _59_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        if(n==0) return new int[][]{};  //这个0这里！
        int[][] result=new int[n][n];
        recursion(result,0,n-1,0,n-1,1);
        return result;
    }
    public void recursion(int[][] result,int hang_begin,int hang_end,int lie_begin,int lie_end,int i){
        if(hang_begin==hang_end && lie_begin==lie_end){
            result[hang_begin][lie_begin]=i;
        }else if (hang_begin<hang_end && lie_begin<lie_end){
            int index_hang=hang_begin;
            int index_lie=lie_begin;
            for(;index_lie<lie_end;index_lie++,i++){
                result[index_hang][index_lie]=i;
            }
            for(;index_hang<hang_end;index_hang++,i++){
                result[index_hang][index_lie]=i;
            }
            for(;index_lie>lie_begin;index_lie--,i++){  //这里该是大于号了
                result[index_hang][index_lie]=i;
            }
            for(;index_hang>hang_begin;index_hang--,i++){   //这里该是大于号了
                result[index_hang][index_lie]=i;
            }
            recursion(result,hang_begin+1,hang_end-1,lie_begin+1,lie_end-1,i);
        }
    }
}
