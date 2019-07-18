package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54359 on 2017/7/21.
 */
public class _118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows != 0) {
            for (int i = 1; i <= numRows; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 1; j <= i; j++) {
                    if (i < 3) {
                        temp.add(1);
                    } else {
                        if (j == 1 || j == i) temp.add(1);
                        else {
                            temp.add(result.get(i - 2).get(j - 2) + result.get(i - 2).get(j - 1));
                        }
                    }
                }
                result.add(temp);
            }
        }
        return result;
    }
//    public List<List<Integer>> generate(int numRows) {
//        if(numRows==0) return new ArrayList<List<Integer>>();
//        List<List<Integer>> result =new ArrayList<>();
//        for(int i=1;i<=numRows;i++){
//            List<Integer> temp=new ArrayList<>();
//            for(int j=1;j<=i;j++){
//                if(i<3){
//                    temp.add(1);
//                }else {
//                    if(j==1 || j==i){
//                        temp.add(1);
//                    }else {
//                        temp.add(result.get(i-2).get(j-2)+result.get(i-2).get(j-1));
//                    }
//                }
//            }
//            result.add(temp);
//        }
//        return result;
//    }
}
