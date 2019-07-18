package LeetCode;

/**
 * Created by 54359 on 2017/6/22.
 */
public class _11_Container_With_Most_Water {

    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1;
        int result = 0;
        while (lo < hi) {
            result = Math.max(result, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return result;
    }
//    public int maxArea(int[] height) {
//        int area=0;
//        int max=0;
//        for(int i=0;i<height.length;i++){
//            for (int j=i+1;j<height.length;j++){
//                max=Math.max(max,mianji(i,j,height[i],height[j]));
//            }
//        }
//
//        return max;
//    }
//    public int mianji(int left,int right,int left_height,int right_height){
//        return (right-left)*Math.min(left_height,right_height);
//    }

    //动态规划
//    public int maxArea(int[] height){
//        int max=0;
//        int left=0,right=height.length-1;
//        while(left<right){
//            max=Math.max(max,(right-left)*Math.min(height[left],height[right]));
//            if(height[left]<height[right]){
//                left++;
//            }else {
//                right--;
//            }
//        }
//        return max;
//    }

}
