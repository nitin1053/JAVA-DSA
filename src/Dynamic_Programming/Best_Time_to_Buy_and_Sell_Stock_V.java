package Dynamic_Programming;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_V {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return pro5(prices, n, 0, 0, dp);
    }

    private int pro5(int[] arr, int n, int ind, int buy, int[][] dp) {
        if (ind >= n) {
            return 0;
        }
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        // If in buying state
        if (buy == 0) {
            int profitBuy = -arr[ind] + pro5(arr, n, ind + 1, 1, dp); // Buy
            int profitNoBuy = pro5(arr, n, ind + 1, 0, dp); // Stay out
            dp[ind][buy] = Math.max(profitBuy, profitNoBuy);
        }

        // If in selling state
        else {
            int profitSell = arr[ind] + pro5(arr, n, ind + 2, 0, dp); // Sell and cooldown for 1 day
            int profitNoSell = pro5(arr, n, ind + 1, 1, dp); // Stay out
            dp[ind][buy] = Math.max(profitSell, profitNoSell);
        }

        return dp[ind][buy];
    }
    static int stockProfit(int[] Arr) {
        int n = Arr.length;
        int dp[][] = new int[n + 2][2];

        // Iterate through the array backwards
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], Arr[ind] + dp[ind + 2][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        // The maximum profit is stored in dp[0][0]
        return dp[0][0];
    }

    public static void main(String args[]) {
        int prices[] = {4, 9, 0, 4, 10};

        System.out.println("The maximum profit that can be generated is " + stockProfit(prices));
    }
}
