package LeetCode;

/**
 * Created by 54359 on 2017/12/16.
 */
public class _7_Reverse_Integer {
    //这里方法不太好，因为他说身处于一个不能超过32位的范围内，那么怎么判断overflow输出0呢？
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = x % 10 + result * 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
        }
        return (int) result;
    }

    //网上的方法
    //还是使用32位，下面newResult算出来之后，再返回去算一下上一轮的结果，如果不相等，那么说明发生越界了
    public int reverse_1(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {    //这里还可以改，改成 newResult/10 !=result,想想减去这一步是多余的
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
