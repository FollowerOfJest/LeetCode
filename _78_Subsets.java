package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 54359 on 2017/7/11.
 */
public class _78_Subsets {
    /*
    //凭着感觉竟然写对了。。。
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int length=nums.length;
        if(length==0) return result;
        recursion(result,temp,nums,0,length);
        result.add(new ArrayList<>());  //这里加上[]
        return result;
    }

    public void recursion(List<List<Integer>> result,List<Integer> temp,int[] nums,int index,int length){
        for(;index<length;index++){
            List<Integer> temp1=new ArrayList<>(temp);  //这里不可以直接用temp
            temp1.add(nums[index]);
            result.add(temp1);
            recursion(result,temp1,nums,index+1,length);
            //temp1.remove(temp1.size()-1);             //不应该有这句的。另一种写法
        }
    }
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int length=nums.length;
        if(length==0) return result;
        recursion(result,temp,nums,0,length);
        result.add(new ArrayList<>());  //这里加上[]
        return result;
    }

    public void recursion(List<List<Integer>> result,List<Integer> temp,int[] nums,int index,int length){
        for(;index<length;index++){
            temp.add(nums[index]);
            result.add(new ArrayList<>(temp));  //这种写法底下要有remove。注意这里加上的东西
            recursion(result,temp,nums,index+1,length);
            temp.remove(temp.size()-1);
        }
    }
}
