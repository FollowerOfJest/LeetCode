package LeetCode;

/**
 * Created by 54359 on 2017/10/2.
 */
public class _67_Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder("");
        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        int indexa = charsa.length - 1, indexb = charsb.length - 1;
        int ain, bin, cin = 0;
        while (indexa > -1 || indexb > -1 || cin == 1) {
            ain = indexa > -1 ? charsa[indexa--] - '0' : 0; //记住这种写法
            bin = indexb > -1 ? charsb[indexb--] - '0' : 0; //还有底下的Character.getNumericValue
            if (ain + bin + cin >= 2) {
                result.append(ain + bin + cin - 2);
                cin = 1;
            } else {
                result.append(ain + bin + cin);
                cin = 0;
            }
        }
        return result.reverse().toString();
    }

    /*用先换算成整数在加起来转换成字符串的方法不对。。因为太长了int和long都不够用了
    public static String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder("");
        long temp = binarytoint(a) + binarytoint(b);
        if(temp==0){
            return "0";
        }
        while (temp!=0){
            stringBuilder.append(temp%2);
            temp=temp/2;
        }
        return stringBuilder.reverse().toString();
    }

    public static int binarytoint(String binary) {
        int toint = 0;
        int beishu2 = 1;
        int length = binary.length();
        for (int index = length - 1; index >= 0; index--) {
            toint = toint + beishu2 * Integer.parseInt(String.valueOf(binary.charAt(index)));
            beishu2 = beishu2 * 2;
        }
        return toint;
    }
    */

    public String addBinary_1(String a, String b) {
        int alength = a.length() - 1;
        int blength = b.length() - 1;
        StringBuilder result = new StringBuilder();
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int ain;
        int bin;
        int cin = 0;
        int s = 0;
        while (alength > -1 || blength > -1 || cin == 1) {
            ain = alength > -1 ? Character.getNumericValue(aArray[alength--]) : 0;  //这个方法要记住
            bin = blength > -1 ? Character.getNumericValue(bArray[blength--]) : 0;
            s = ain ^ bin ^ cin;
            cin = ((ain + bin + cin) >= 2) ? 1 : 0;
            result.append(s);
        }
        return result.reverse().toString();
    }
}

