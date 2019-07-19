package LeetCode;

/**
 * Created by 54359 on 2017/6/28.
 */
public class _34_Search_for_a_Range {
    //这个用了3次二分搜索，可以用2次的
    public static int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        int length=nums.length;
        int begin=0,end=length-1;
        //int shang,xia;
        int qian_left=0,qian_mid=0,qian_right=0,hou_left=0,hou_mid=0,hou_right=0;
        int mid=0;
        while(begin<=end){
            mid=(begin+end)/2;
            if(nums[mid]==target){
                  /*
                  //应该还要继续二分
                shang=mid;
                xia=mid;
                while(shang>=1 && nums[shang]==nums[shang-1]){
                    shang--;
                }
                while(nums.length>=2 && xia<=length-2 && nums[xia]==nums[xia+1]){
                    xia++;
                }
                return new int[]{shang,xia};
                */
                qian_left=begin;
                qian_right=mid;
                while (qian_left<=qian_right){
                    qian_mid=(qian_left+qian_right)/2;
                    if(nums[qian_mid]==target){
                        qian_right=qian_mid-1;
                    }else{
                        qian_left=qian_mid+1;
                    }
                }

                hou_left=mid;
                hou_right=end;
                while (hou_left<=hou_right){
                    hou_mid=(hou_left+hou_right)/2;
                    if(nums[hou_mid]==target){
                        hou_left=hou_mid+1;
                    }else {
                        hou_right=hou_mid-1;
                    }
                }
                return new int[]{qian_left,hou_left-1}; //这里得好好想想。错了好几遍
            }else if(nums[mid]<target){
                begin=mid+1;
            }else{
                end=mid-1;
            }
        }
        return result;
    }
    //只用了2次二分
    public int[] searchRange_2(int[] A, int target) {
        int[] res = {-1,-1};
        if(A==null || A.length==0)
        {
            return res;
        }
        int ll = 0;
        int lr = A.length-1;
        while(ll<=lr)
        {
            int m = (ll+lr)/2;
            if(A[m]<target) //这里，这样是找第一个，最终通过ll找起始
            {
                ll = m+1;
            }
            else
            {
                lr = m-1;
            }
        }
        int rl = 0;
        int rr = A.length-1;
        while(rl<=rr)
        {
            int m = (rl+rr)/2;
            if(A[m]<=target)    //这里，注意和上边的不同，这样是找最后一个，通过rr找最后
            {
                rl = m+1;
            }
            else
            {
                rr = m-1;
            }
        }
        if(ll<=rr)  //注意这里是ll和rr，这里需要判断  5 7，如果target是6
        {
            res[0] = ll;
            res[1] = rr;
        }
        return res;
    }


    //找left来确定始找左边还是右边
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange_3(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }


}
