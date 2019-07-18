package LeetCode;

import java.util.List;

/**
 * Created by 54359 on 2017/7/21.
 */
public class _120_Triangle {
    //空间复杂度位O(n)，从底下往上搞比较好
    public int minimumTotal(List<List<Integer>> trgl) {
        int sz = trgl.size();
        int[] results = new int[sz+1];
        for(int i=sz-1; i>=0; i--) {
            List<Integer> tmp = trgl.get(i);
            for(int j=0; j<tmp.size(); j++) {
                results[j] = Math.min(results[j], results[j+1]) + tmp.get(j);   //先把最后一行存到数组里边去，然后网上一行在做相加判断，更新数组，如此往复
            }
        }
        return results[0];
    }
}
