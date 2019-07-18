package LeetCode;

/**
 * Created by 54359 on 2017/10/2.
 */
public class _58_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int result=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)==' '){
                if (result!=0)
                    return result;
            }else {
                result++;
            }
        }
        return result;
    }

    //写了三次，忘了一些情况 ，全是空格，最后是空格前边有字符
    //思想应该是倒着来的没错
    public int lengthOfLastWord_1(String s) {
        int result=0;
        int length=s.length();
        for(int index=length-1;index>=0;index--){
            if(s.charAt(index)==' '){
                if(result!=0){
                    return result;
                }
            }else {
                result++;
            }
        }
        return result;
    }

//    public int lengthOfLastWord(String s) {
//        s = s.trim();
//        int lastIndex = s.lastIndexOf(' ') + 1;
//        return s.length() - lastIndex;
//    }
}
