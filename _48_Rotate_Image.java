package LeetCode;

/**
 * Created by 54359 on 2017/6/30.
 */
public class _48_Rotate_Image {
    /*
     * //最蠢的方法 public static void rotate(int[][] matrix) { int
     * hang_lie=matrix.length; int[][] temp=new int[hang_lie][hang_lie]; for(int
     * i=0;i<hang_lie;i++){ for (int j=0;j<hang_lie;j++){ temp[i][j]=matrix[i][j]; }
     * } for(int i=0;i<hang_lie;i++){ for (int j=0;j<hang_lie;j++){
     * matrix[j][hang_lie-i-1]=temp[i][j]; } } }
     */
    // n*n
    public static void rotate_1(int[][] matrix) {
        int length = matrix.length;
        int temp;
        int half_1, half_2;
        if (length % 2 == 0) { // 奇数或偶数要旋转的不一样，偶数取一半就好了
            half_1 = length / 2;
            half_2 = length / 2;
        } else { // 奇数需要行列之一到一半，另一个减1，否则会有正中的元素又多移了几遍
            half_1 = length / 2;
            half_2 = length / 2 + 1;
        }
        for (int i = 0; i < half_1; i++) {
            for (int j = 0; j < half_2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - 1 - i][length - j - 1];
                matrix[length - 1 - i][length - j - 1] = matrix[j][length - 1 - i];
                matrix[j][length - 1 - i] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //终止条件是n/2
        for (int i = 0; i < n / 2; i++) {
            //搞清楚这里的起始位置和终止位置
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

}
