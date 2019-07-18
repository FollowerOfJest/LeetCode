package LeetCode;

import java.util.*;

public class _12_Integer_to_Roman{
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1}; 
        String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuffer result=new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int x=num/values[i];
            if(x==0)
                continue;
            for(int j=x;j>0;j--){
                result.append(strs[i]);
            }
            num=num-values[i]*x;
            if(num==0)
                break;
        }

        return result.toString();
    }
}