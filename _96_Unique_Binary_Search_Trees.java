package LeetCode;

/**
 * Created by 54359 on 2017/8/17.
 */
public class _96_Unique_Binary_Search_Trees {
    /*
    //自己写的时间超过了，但应该是正确的，使用递归，但完全不必要这么复杂可以在II里边尝试这种方法
    public int numTrees(int n) {
        int result=0;
        for(int i=1;i<=n;i++){
            result+=recursion_left(1,i-1)*recursion_right(i+1,n);
        }
        return result;
    }
    public int recursion_left(int begin,int end){
        int temp=0;
        if(end<=begin) return 1;
        for(int i=begin;i<=end;i++){
            temp+=recursion_left(begin,i-1)*recursion_right(i+1,end);
        }
        return temp;
    }
    public int recursion_right(int begin,int end){
        int temp=0;
        if(begin>=end) return 1;
        for(int i=begin;i<=end;i++){
            temp+=recursion_left(begin,i-1)*recursion_right(i+1,end);
        }
        return temp;
    }
    */
    //看的网上的方法。先定义一个矩阵，然后如果0和1个点那么只有一种排列
    //G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
    //接下来的，就是比如左边没有，右边n-1个相乘+左边1个右边n-2.。。。。+左边n-1，右边1个相乘
    public int numTrees(int n) {
        int[] result=new int[n+1];
        result[0]=1;
        result[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<=i-1;j++){
                result[i]+=result[j]*result[i-j-1];
            }
        }
        return result[n];
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
