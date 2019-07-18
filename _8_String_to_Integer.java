package LeetCode;

import java.util.*;

public class  _8_String_to_Integer{

    public int myAtoi(String str) {
        int i = 0, j = 0, len = str.length();
        boolean negative = false;
        for (i = 0; i < len; i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                break;
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                negative = str.charAt(i) == '-';
                i++;
                break;
            } else if (str.charAt(i) != ' ') {
                return 0;
            }
        }
        for (j = i; j < len; j++) {
            if (str.charAt(j) < '0' || '9' < str.charAt(j)) {
                break;
            }
        }
        int ret = 0;
        String num = str.substring(i, j);
        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (negative) {
                //这里判断溢出的情况和第7题一样
                if (ret < Integer.MIN_VALUE / 10|| ret == Integer.MIN_VALUE / 10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 - cur;
            } else {
                if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + cur;
            }
        }
        return ret;
    }


    public int myAtoi_s(String str) {
        //去除掉前后的空格
        String strr = str.trim();
        //存储最终过滤出来的字符串
        String strrr = null;
        //字符串不为空时并且字符串不全是空白字符串时才转换
        if(strr != null && strr.isEmpty() == false){
            char f = strr.charAt(0);
            //判断字符串中的第一个非空格字符是不是一个有效整数字符
            if(f >= '0' && f <= '9' || f == '+'|| f == '-'){
                strrr = strr.substring(0,1); // 把第一位放进去(只能是数字、正负号)
                //这时候循环只要数字，因为正负号只能出现在第一位
                for(int i = 1; i<strr.length();i++){
                    if(strr.charAt(i) >= '0' && strr.charAt(i) <= '9'){
                        strrr = strr.substring(0,i+1);
                    }
                    //这是遇到不符合要求的字符，直接忽略剩余元素
                    else{break;}
                }
            }
        }
        //判断最终字符串是否为空或则只有一个正负号
        if(strrr == null || strrr.equals("+") || strrr.equals("-"))
            //此时strrr是String对象，如果使用==比较则比较的时内存地址
            return 0;
        //最终转换成的数字
        int num = 0;
        //使用异常机制打印结果
        try{
            num = Integer.parseInt(strrr);
        }catch (Exception e){
            if(strrr.charAt(0) == '-')
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        return num;
    }

}