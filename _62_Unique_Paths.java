package LeetCode;

/**
 * Created by 54359 on 2017/7/4.
 */
public class _62_Unique_Paths {
    //mn对应数组,到达第一行和第一列都只有1路径
    //其他点的路径位左边加上边的路径可能的和
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;
        int[][] nums=new int[m][n];
        for(int i=0;i<n;i++){
            nums[0][i]=1;
        }
        for(int i=0;i<m;i++){
            nums[i][0]=1;
        }
        for(int hang=1;hang<m;hang++){
            for (int lie=1;lie<n;lie++){
                nums[hang][lie]=nums[hang-1][lie]+nums[hang][lie-1];
            }
        }
        return nums[m-1][n-1];
    }
}
