/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */
class Solution {
    public int numTrees(int n) {
        if(n<1)
            return 0;
        int result[]=new int[n+1];
        //零个节点，null，也是一种方案，所以这里设置为1
        result[0]=1;
        result[1]=1;
        for (int i = 2; i <=n; i++) {
            //这里可以理解为从左边0个到i-1  * 右边j-i-i 个到0个
            //以3举例，result2=2=1*1+1*1
            //result3=result0*2+result1*result1+result2*result0
            //      = 1*2+1*1+2*1=5  
            for (int j = 0; j < i; j++) {
                result[i]+= result[j]*result[i-j-1];
            }
        }
        return result[n];
    }
}

