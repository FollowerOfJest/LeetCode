package LeetCode;

/**
 * Created by 54359 on 2017/7/24.
 */
public class _167_Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int lo = 0, hi = numbers.length - 1;
        int temp;
        while (lo < hi) {
            temp = numbers[lo] + numbers[hi];
            if (temp == target) {
                result[0] = lo+1;
                result[1] = hi+1;
                break;
            } else if (temp < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return result;
    }
//    //跟_1twoSum相比，这次数组是有序得了
//    public int[] twoSum(int[] numbers, int target) {
//        int[] result=new int[2];
//        int begin=0;
//        int end=numbers.length-1;
//        int temp;
//        while(begin<end){
//            temp=numbers[begin]+numbers[end];
//            if(temp==target){
//                result[0]=begin+1;
//                result[1]=end+1;
//                return result;
//            }else if(temp<target){
//                begin++;
//            }else {
//                end--;
//            }
//        }
//
//        return result;
//    }
}
