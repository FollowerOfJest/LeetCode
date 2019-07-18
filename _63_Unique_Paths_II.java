package LeetCode;

/**
 * Created by 54359 on 2017/7/4.
 */
public class _63_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int hang=obstacleGrid.length;
        if(hang==0) return 0;
        int lie=obstacleGrid[0].length;
        if (lie==0) return 0;
        int[][] nums=new int[hang][lie];
        if(obstacleGrid[0][0]==1) nums[0][0]=0;
        else nums[0][0]=1;
        for(int i=1;i<lie;i++){
            if(obstacleGrid[0][i]==1) nums[0][i]=0;
            else nums[0][i]=nums[0][i-1];
        }
        for(int j=1;j<hang;j++){
            if(obstacleGrid[j][0]==1) nums[j][0]=0;
            else nums[j][0]=nums[j-1][0];
        }
        for(int i=1;i<hang;i++){
            for(int j=1;j<lie;j++){
                if(obstacleGrid[i][j]==1) nums[i][j]=0;
                else nums[i][j]=nums[i-1][j]+nums[i][j-1];
            }
        }
        return nums[hang-1][lie-1];
    }
}
