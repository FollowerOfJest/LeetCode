/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */
class Solution {
    public int numDecodings_1(String s) {
        if(s==null||s.length()==0)
            return 0;
        return recursion(s,0);
    }
    //最开始写的，这个递归的边界条件要考虑很多
    public int recursion(String s,int index){
        if(index==s.length()-1 && s.charAt(index)=='0') //‘0’对应这种情况
            return 0;
        if(index>=s.length()-1)
            return 1;
        if(s.charAt(index)=='0')
            return 0;
        if(s.charAt(index)>'2'){
            return recursion(s,index+1);
        }
        if(s.charAt(index)=='2'){
            if(s.charAt(index+1)=='0' || s.charAt(index+1)>'6')
                return recursion(s,index+2);
            return recursion(s,index+1)+recursion(s,index+2);
        }
        //'1'
        if(s.charAt(index+1)=='0')
            return recursion(s,index+2);
        return recursion(s,index+1)+recursion(s,index+2);
    }

    public int numDecodings(String s) {
        if(s==null||s.length()==0)
            return 0;
        int[] result=new int[s.length()+1];
        int index=s.length()-1;
        result[index+1]=1;
        if(s.charAt(index)!='0'){
            result[index--]=1;
        }
        while (index>=0) {
            if(s.charAt(index)=='0')
                result[index]=0;
            if(s.charAt(index)>'2')
                result[index]=result[index+1];
            if(s.charAt(index)=='2'){
                if(s.charAt(index+1)>'6'){
                    result[index]=result[index+1];
                }else{//就算是201，这种result[index+1]是0，不要额外的if判断
                    result[index]=result[index+1]+result[index+2];
                }
            }
            if(s.charAt(index)=='1'){
                result[index]=result[index+1]+result[index+2];
            }
            index--;
        }
        return result[0];
    }


}

