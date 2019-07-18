package LeetCode;

/**
 * Created by 54359 on 2017/7/23.
 */
public class _122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int result = 0;
        int index_temp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[index_temp]) { //可以卖了
                result += prices[i] - prices[index_temp];
            }
            index_temp = i;
        }
        return result;
    }

//    //写了3遍。
//    public int maxProfit(int[] prices) {
//        int length=prices.length;
//        int min=Integer.MAX_VALUE;
//        int temp=0;
//        int result=0;
//        for(int i=0;i<length;i++){
//            if(prices[i]<min){
//                min=prices[i];
//                if(temp!=0){    //这里，如果后面出现新的最小值，那么这里如果买了股票应该先卖出去   [7 1 5 0 6 4]
//                    result+=temp;
//                    temp=0;
//                }
//            }else{
//                if(prices[i]-min>temp){
//                    temp=prices[i]-min;
//                    if(i==length-1) result+=temp;   //如果到最后一个了，也要卖出去    [1 2]
//                }else {                             //买了股票，如果后边的股票比买的时候高，但收益比前几天低，也要卖出去然后赚下一笔钱[7 1 5 3 6 4]
//                    result+=temp;
//                    min=prices[i];
//                    temp=0;
//                }
//            }
//        }
//        return result;
//    }
}
