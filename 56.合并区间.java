import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            result.add(new int[] { left, right });
            i++;
        }
        int[][] resultarr=new int[result.size()][2];
        for(int x=0;x<result.size();x++){
            resultarr[x][0]=result.get(x)[0];
            resultarr[x][1]=result.get(x)[1];
        }
        return resultarr;

    }
}
