package LeetCode;

/**
 * Created by 54359 on 2017/7/1.
 */
public class _55_Jump_Game {
    /*对了但是慢，改一改，应该是start或者index要加1
    public boolean canJump(int[] nums) {
        boolean result=false;
        int temp=0;
        int start=0,new_start=0;
        int index=start;
        for(;index<=(start+nums[start]);){
            if(temp<=index+nums[index]){
                temp=index+nums[index];
                new_start=index;
                if(temp>=nums.length-1) return true;
            }
            if(index==start+nums[start]){
                //if(temp>=nums.length-1) return true;  //注释掉了，因为跟上边temp的判断重复了
                start=new_start;
                index=start;    //这里很多余
                if(nums[start]==0) return false;
            }
            index++;
        }
        return result;
    }
    */
    //作为稍微的修改，还是慢。。。
    public boolean canJump(int[] nums) {
        boolean result=false;
        if(nums.length==1) return true;
        int temp=0;
        int start=0,new_start=0;
        int index=start+1;
        if (nums[start]==0) return false;
        for(;index<=start+nums[start];){
            if(temp<=index+nums[index]){
                temp=index+nums[index];
                new_start=index;
                if(temp>=nums.length-1) return true;
            }
            if(index==start+nums[start]){
                if(nums[new_start]==0) return false;
                start=new_start;
            }
            index++;
        }
        return result;
    }

    //网上看的方法
    //reachable代表能跳的最大值，如果循环i比这个值大了，说明跳不出来，所以就是代表不能跳到。
    public boolean canJump_1(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    //网上看的方法，偶尔能达到最快，偶尔也很慢。
    //思想是倒着来的。如果倒数第N个是0，那就要往前找
    public boolean canJump_3(int[] nums) {
        if(nums.length < 2) return true;
        for(int curr = nums.length-2; curr>=0;curr--){
            if(nums[curr] == 0){
                int neededJumps = 1;
                while(neededJumps > nums[curr]){
                    neededJumps++;
                    curr--;
                    if(curr < 0) return false;
                }
            }
        }
        return true;
    }
}
