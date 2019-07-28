/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */
class Solution {
    public List<Integer> grayCode_1(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        gray.add(0); // 初始化 n = 0 的解
        for (int i = 0; i < n; i++) {
            int add = 1 << i; // 要加的数
            // 倒序遍历，并且加上一个值添加到结果中
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }

    /**
     * 以二进制为 0 值的格雷码为第零项，
     * 第一项改变最右边的位元，
     * 第二项改变右起第一个为1的位元的左边位元，
     * 第三、四项方法同第一、二项，
     * 如此反复，即可排列出n个位元的格雷码。
     */
    public List<Integer> grayCode2(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        gray.add(0); //初始化第零项
        for (int i = 1; i < 1 << n; i++) {
            //得到上一个的值
            int previous = gray.get(i - 1);
            //同第一项的情况
            if (i % 2 == 1) {
                previous ^= 1; //和 0000001 做异或，使得最右边一位取反
                gray.add(previous);
            //同第二项的情况
            } else {
                int temp = previous;
                //寻找右边起第第一个为 1 的位元
                for (int j = 0; j < n; j++) {
                    if ((temp & 1) == 1) {
                        //和 00001000000 类似这样的数做异或，使得相应位取反
                        previous = previous ^ (1 << (j + 1));
                        gray.add(previous);
                        break;
                    }
                    temp = temp >> 1;
                }
            }
        }
        return gray;
    }
    
}
