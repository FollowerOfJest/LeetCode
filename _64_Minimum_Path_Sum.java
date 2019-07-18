package LeetCode;

/**
 * Created by 54359 on 2017/7/4.
 */
public class _64_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int hang=grid.length;
        if(hang==0) return 0;
        int lie=grid[0].length;
        int[][] nums=new int[hang][lie];
        nums[0][0]=grid[0][0];
        for(int i=1;i<lie;i++){
            nums[0][i]=grid[0][i]+nums[0][i-1];
        }
        for(int i=1;i<hang;i++){
            nums[i][0]=grid[i][0]+nums[i-1][0];
        }
        for(int i=1;i<hang;i++){
            for(int j=1;j<lie;j++){
                if(nums[i-1][j]<nums[i][j-1]){
                    nums[i][j]=grid[i][j]+nums[i-1][j];
                }else {
                    nums[i][j]=grid[i][j]+nums[i][j-1];
                }
            }
        }
        return nums[hang-1][lie-1];
    }
}
