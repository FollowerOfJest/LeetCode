package LeetCode;

/**
 * Created by 54359 on 2017/6/24.
 */
public class _27_Remove_Element {

    public int removeElement(int[] nums, int val) {
        int m=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[m++]=nums[i];
            }
        }
        return m;
    }



//    //两种方法，第一种好理解
//    public int removeElement(int[] A, int elem) {
//        int m = 0;
//        for(int i = 0; i < A.length; i++){
//            if(A[i] != elem){
//                A[m] = A[i];
//                m++;
//            }
//        }
//        return m;
//    }
    /*
    int removeElement(int A[], int n, int elem) {
        int i = 0;
        while (i < n) {
            if (A[i] == elem) {
                A[i] = A[n - 1];
                n--;
            }
            else
                i++;
        }
        return n;
    }
    */
}
