/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */
class Solution {
    /*
    和Search in Rotated Sorted Array唯一的区别是这道题目中元素会有重复的情况出现。不过正是因为这个条件的出现，出现了比较复杂的case，甚至影响到了算法的时间复杂度。
    原来我们是依靠中间和边缘元素的大小关系，来判断哪一半是不受rotate影响，仍然有序的。
    而现在因为重复的出现，如果我们遇到中间和边缘相等的情况，我们就丢失了哪边有序的信息，因为哪边都有可能是有序的结果。
    假设原数组是{1,2,3,3,3,3,3}，那么旋转之后有可能是{3,3,3,3,3,1,2}，或者{3,1,2,3,3,3,3}，
    这样的我们判断左边缘和中心的时候都是3，如果我们要寻找1或者2，我们并不知道应该跳向哪一半。解决的办法只能是对边缘移动一步，
    直到边缘和中间不在相等或者相遇，这就导致了会有不能切去一半的可能。所以最坏情况（比如全部都是一个元素，或者只有一个元素不同于其他元素，而他就在最后一个）
    就会出现每次移动一步，总共是n步，算法的时间复杂度变成O(n)。
    */
    public boolean search(int[] A, int target) {
        if(A==null || A.length==0) return false;
        int l = 0;
        int r = A.length-1;
        while(l<=r)
        {
            int m = (l+r)/2;
            if(A[m]==target) return true;
            if(A[m]>A[l])
            {
                if(A[m]>target && A[l]<=target)
                {r = m-1;}
                else
                {l = m+1;}
            }
            else if(A[m]<A[l])
            {
                if(A[m]<target && A[r]>=target)
                {l = m+1;}
                else
                {r = m-1;}
            }
            else
            {
                l++;
            }
        }
        return false;
    }
}

