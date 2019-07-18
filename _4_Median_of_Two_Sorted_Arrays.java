package LeetCode;

/**
 * Created by 54359 on 2017/6/21.
 */

public class _4_Median_of_Two_Sorted_Arrays {
    /*myself,slow
    public static double findMedianSortedArrays_myself(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
        int[] temp=new int[len];
        System.arraycopy(nums1,0,temp,0,nums1.length);
        System.arraycopy(nums2,0,temp,nums1.length,nums2.length);
        Arrays.sort(temp);
        if(len%2==0){
            return (double)(temp[len/2-1]+temp[len/2])/2;
        }
        else return temp[len/2];

    }
    */

    //hard_deserve deep thinking
    //O(log(m+n))
    public static double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int total = m+n;
        if (total%2 != 0)
            return (double) findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
        else {
            double x = findKth(A, 0, m-1, B, 0, n-1, total/2);//k传得是第k个，index实则k-1
            double y = findKth(A, 0, m-1, B, 0, n-1, total/2+1);//k传得是第k个，index实则k-1
            return (double)(x+y)/2;
        }
    }
    public static int findKth(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
        int m = aend - astart + 1;
        int n = bend - bstart + 1;
        if(m>n)
            return findKth(B,bstart,bend,A,astart,aend,k);
        if(m==0)
            return B[k-1];
        if(k==1)
            return Math.min(A[astart],B[bstart]);
        int partA = Math.min(k/2,m);
        int partB = k - partA;
        if(A[astart+partA-1] < B[bstart+partB-1])
            return findKth(A,astart+partA,aend,B,bstart,bend,k-partA);
        else if(A[astart+partA-1] > B[bstart+partB-1])
            return findKth(A,astart,aend,B,bstart+partB,bend,k-partB);
        else
            return A[astart+partA-1];
    }
}
