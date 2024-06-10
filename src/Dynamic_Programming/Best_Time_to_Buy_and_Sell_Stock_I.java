package Dynamic_Programming;

public class Best_Time_to_Buy_and_Sell_Stock_I {
    static int maxprofit(int[] prices){
        int maxprofit=0;
        int min_profit=prices[0];
        for(int i=1;i<prices.length;i++){
            int currprofit=prices[i]-min_profit;
            maxprofit=Math.max(currprofit,maxprofit);
            min_profit=Math.min(min_profit,prices[i]);
        }
        return maxprofit;
    }
    public static void main(String args[]) {

        int[] Arr  ={7,1,5,3,6,4};

        System.out.println("The maximum profit by selling the stock is "+
                maxprofit(Arr));
    }
}
