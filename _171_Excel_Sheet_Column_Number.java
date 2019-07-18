package LeetCode;

/**
 * Created by 54359 on 2017/10/13.
 */
public class _171_Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        int result = 0;
        int xishu = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += ((int) s.charAt(i) - 64) * xishu;
            xishu *= 26;
        }
        return result;
    }

    //根168题目一样，就是反过来，一次写对。。但貌似速度慢。
//    public int titleToNumber(String s) {
//        int result=0;
//        char[] temp = s.toCharArray();
//        int xishu=1;
//        int charvalue=0;
//        for(int index=s.length()-1;index>=0;index--){
//            charvalue=Character.getNumericValue(temp[index])-9;
//            result=result+charvalue*xishu;
//            xishu=xishu*26;
//        }
//        return result;
//    }

//    //网上这个表示方法更快，不要用s.toCharArray，scharAt(i)，就很好了
//    public int titleToNumber(String s) {
//        int result = 0;
//        for (int i = 0; i < s.length(); i++){
//            result = result * 26 + (s.charAt(i) - 'A' + 1);//记住这种形式，两个字符相减得到了数值
//        }
//        return result;
//    }
}
