package LeetCode;

/**
 * Created by 54359 on 2017/6/25.
 */
public class _31_Next_Permutation {
    public void nextPermutation(int[] nums) {
        if(nums.length>1){    //只有一个元素不需要动
            for(int i=nums.length-1;i>=1;i--){
                if(nums[i]>nums[i-1]){  //找到需要调整的数nums[i-1]
                    for (int j=nums.length-1;j>i-1;j--){    //找到nums[i-1]之后，调整需要先把后序序列中第一个比它大的数对换
                        if(nums[j]>nums[i-1]){
                            int change=nums[i-1];
                            nums[i-1]=nums[j];
                            nums[j]=change;
                            for(int k=i,l=nums.length-1;k<l;k++,l--){//对换完毕后再把后面的序列从小到大排列，逆序
                                int huan=nums[l];
                                nums[l]=nums[k];
                                nums[k]=huan;
                            }
                            break;
                        }
                    }
                    break;
                }else {
                    //逆序
                    if(i==1&&nums[1]<nums[0]){
                        for(int start=0,end=nums.length-1;start<end;start++,end--){
                            int huanhuan=nums[start];
                            nums[start]=nums[end];
                            nums[end]=huanhuan;
                        }
                    }
                }
            }
        }
    }


    public void nextPermutation_1(int[] nums) {
        int i = nums.length - 2;
        //找到i
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //找到i+1到最后一个元素中第一个大于于i位置的元素
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        //逆序
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
