package LeetCode;

import java.util.*;

public class _13_Roman_to_Integer{
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();//使用map把他们对应存储起来
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int res=0;          //存放结果
        int current=0;     //第一个值
        int next=0;       //后一个值
        
        for(int i=0;i<s.length()-1;++i){        //注意这里的s.length()-1是为了防止下标越界
            current=map.get(s.charAt(i));
            next=map.get(s.charAt(i+1));

            if(next/current==5||next/current==10){    //如果满足后一个是前一个5倍或10倍
                res-=map.get(s.charAt(i));            //结果减掉当前值（相当于加了相反数）
            }else{
                res+=map.get(s.charAt(i));            //否则加上当前值
            }
        }
        res+=map.get(s.charAt(s.length()-1));        //最后再加上字符串末尾的值
        return res;
    }


}