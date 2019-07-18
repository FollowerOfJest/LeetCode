package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54359 on 2017/7/21.
 */
public class _119_Pascals_Triangle_II {
    /*写的太蠢了
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        List<List<Integer>> temp=new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            result=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(i<2) result.add(1);
                else {
                    if(j==0 || j==i) result.add(1);
                    else result.add(temp.get(i-1).get(j-1)+temp.get(i-1).get(j));
                }
            }
            if(i==rowIndex){
                return result;
            }
            temp.add(result);
        }
        return result;
    }
    */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(1);temp.add(1);
        for(int i=0;i<=rowIndex;i++){
            result=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(i<2) result.add(1);
                else {
                    if(j==0 || j==i) result.add(1);
                    else result.add(temp.get(j-1)+temp.get(j));
                }
            }
            temp=result;
            if(i==rowIndex) return result;
        }
        return result;
    }

    /*这个方法更好，不用创建多余的，但貌似速度也没有快多少，因为老是在变动Arraylist
    public List<Integer> getRow(int rowIndex) {
	List<Integer> list = new ArrayList<Integer>();
	if (rowIndex < 0)
		return list;

	for (int i = 0; i < rowIndex + 1; i++) {
		list.add(0, 1);
		for (int j = 1; j < list.size() - 1; j++) {
			list.set(j, list.get(j) + list.get(j + 1));
		}
	}
	return list;
    }
    //这个更好一些
    public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<Integer>();
    for(int i = 0;i<rowIndex+1;i++) {
    		res.add(1);
    		for(int j=i-1;j>0;j--) {
    			res.set(j, res.get(j-1)+res.get(j));
    		}
    }
    return res;
}
     */
}
