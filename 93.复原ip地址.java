/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList();
        recursion(s,0,0,result,"");
        
        return result;
    }
    public void recursion(String s,int index,int count,List<String> result,String temp){
        if(index==s.length() && count==4){
            result.add(temp.substring(0,temp.length()-1));//remove last .
            return;
        }
        if(count>4 || index>=s.length())
            return;
        for (int i = index; i < index+3; i++) {
            if(i<s.length()){
                //index代表开始，开始的是0
                if(s.charAt(i)=='0'&& i==index){
                    recursion(s,index+1,count+1,result,temp+"0.");
                    break;
                }
                if(Integer.parseInt(s.substring(index,i+1))<=255)
                    //这里底下是i+1，开始写错了
                    recursion(s,i+1,count+1,result,temp+s.substring(index,i+1)+".");
            }else{
                break;
            }
        }
    }
}

