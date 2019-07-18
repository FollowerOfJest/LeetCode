package LeetCode;

/**
 * Created by 54359 on 2017/7/23.
 */
public class _121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int result = 0;
        int index_min = 0;
        int temp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[index_min]) {
                index_min = i;
            } else {
                temp = prices[i] - prices[index_min];
                if (temp > result) result = temp;
            }
        }
        return result;
    }

//    //找最小值，然后如果不是最小值，就说明可以卖出整数得钱，这个钱要不断比较
//    public int maxProfit(int[] prices) {
//        int min=Integer.MAX_VALUE;
//        int result=0;
//        for(int i=0;i<prices.length;i++){
//            if(prices[i]<min){
//                min=prices[i];
//            }else if(prices[i]-min>result){
//                result=prices[i]-min;
//            }
//        }
//        return result;
//    }
}
