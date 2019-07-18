package LeetCode;

/**
 * Created by 54359 on 2017/10/12.
 */
public class _168_Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder("");
        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
    /*
    //自己写的。。但是改了好多次。除以26，然后如果余数为0，比如刚好是26，那么下一轮的除数应该再将去个1
    public String convertToTitle(int n) {
        StringBuilder result=new StringBuilder();
        int chushu=n/26;
        int yushu=n%26;
        if(yushu==0){
            result.insert(0,'Z');
//            result.append('Z');
            chushu=chushu-1;
        }else {
            result.insert(0,Character.valueOf((char)(64+yushu)));
            //result.append(Character.valueOf((char)(64+yushu)));
        }
        while (chushu!=0){
            yushu=chushu%26;
            chushu=chushu/26;
            if(yushu==0){
                result.insert(0,'Z');
//            result.append('Z');
                chushu=chushu-1;
            }else {
                result.insert(0,Character.valueOf((char)(64+yushu)));
                //result.append(Character.valueOf((char)(64+yushu)));
            }
        }
        return result.toString();
//        return result.reverse().toString();
    }
    */
    //网上写的方法，1-26映射到AZ，那么就应该把0-25映射到AZ，这样的话26进制就合理
    //没有必要用reverse，insert要记住
//    public String convertToTitle(int n) {
//        StringBuilder result=new StringBuilder();
//        while (n>0){
//            n--;//这里这个减一是关键所在。正确的把1-26转换为0-25
//            result.insert(0,(char)(65 + n % 26));//65对应的是'A',记住这种字符的写法 (char)(num)
//            n=n/26;
//        }
//        return result.toString();
//    }
}
