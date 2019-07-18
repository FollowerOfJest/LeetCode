package LeetCode;

/**
 * Created by 54359 on 2017/7/24.
 */
public class _169_Majority_Element {

    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    result = nums[i];
                    count = 0;
                }
            }
        }
        return result;
    }
    /*占据一半以上的元素？那不就排序完之后中间的那个
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    */
    //这个倒是很有想法，因为主要元素占据一半以上，那么不停的一个个判断是否相同，count=0那么就切换临时量，这样保证count是正数，或者最后刚好是0的值就是主要值
//    public int majorityElement(int[] num) {
//        int major=num[0], count = 1;
//        for(int i=1; i<num.length;i++){
//            if(count==0){
//                count++;
//                major=num[i];
//            }else if(major==num[i]){
//                count++;
//            }else count--;
//        }
//        return major;
//    }

}
