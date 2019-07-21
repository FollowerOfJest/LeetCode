/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */
class Solution {
    public String getPermutation(int n, int k) {
        int pos = 0;
        //存放123456789
        List<Integer> numbers = new ArrayList<>();
        //存放阶乘
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;
        /*
            比如1234  找第5个，fac[]就是{1，1，2，6，24}
                                        0  1  2 3   4
                                    底下从1开始，n-i最开始是3
            1 开始234 最多有阶乘6个，所以用k处以6，
            但是如果刚好是6或12，那不对，所以要减去1，然后5/6=0，
            所以0坐标也就是1应该是要添加的第一个字符
            然后1添加了，删除1，剩下234同上
            k -= index * factorial[n - i];
            然后要从 2-34   3-24  4-23中找
            4/2=2,所以要从4-23中找，添加4，删掉4，剩下23
            k=k-2*阶乘数组中的2，剩下0
            这样的话最后是1423，对没错
            
        */

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(sb);
    }
}
