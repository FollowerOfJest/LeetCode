/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */
class Solution {

    public List<Integer> getRow_1(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(1);temp.add(1);
        for(int i=0;i<=rowIndex;i++){
            result=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(i<2) result.add(1);
                else {
                    if(j==0 || j==i) result.add(1);
                    else result.add(temp.get(j-1)+temp.get(j));
                }
            }
            temp=result;
            if(i==rowIndex) return result;
        }
        return result;
    }

    public List<Integer> getRow_3(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp,1);
        for(int i = 2;i < dp.length;i++){
            for(int j = i - 1;j > 0;j--)
                dp[j] = dp[j] + dp[j - 1];
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }

    /**
 * 获取杨辉三角的指定行
 * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
 * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
 */
public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<>(rowIndex + 1);
    //用long的原因是为了防止int溢出
    long cur = 1;
    for (int i = 0; i <= rowIndex; i++) {
        res.add((int) cur);
        cur = cur * (rowIndex-i)/(i+1);
    }
    return res; 
}
}

