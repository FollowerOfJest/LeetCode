import java.util.List;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */
class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[1]<intervals[i][0]){
                result.add(newInterval);
                newInterval=intervals[i];
            }else if(newInterval[0]>intervals[i][1]){
                result.add(intervals[i]);
            }else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[0][]);
    }

    public int[][] insert_1(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList();
        List<int[]> temp = new ArrayList();
        if (intervals.length == 0) {
            result.add(new int[] { newInterval[0], newInterval[1] });
            return result.toArray(new int[0][]);
        }
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] <= intervals[i][0])
                temp.add(newInterval);
            temp.add(intervals[i]);
        }
        if (newInterval[0] > intervals[intervals.length - 1][0]) {
            temp.add(newInterval);
        }
        int i = 0;
        while (i < temp.size()) {
            int left = temp.get(i)[0];
            int right = temp.get(i)[1];
            while (i < temp.size() - 1 && right >= temp.get(i + 1)[0]) {
                right = Math.max(right, temp.get(i + 1)[1]);
                i++;
            }
            result.add(new int[] { left, right });
            i++;
        }

        return result.toArray(new int[0][]);
    }
}
