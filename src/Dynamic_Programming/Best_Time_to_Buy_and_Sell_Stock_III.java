package Dynamic_Programming;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_III {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return getans(prices, n, 0, 0, 2, dp);
    }

    public int getans(int[] prices, int n, int ind, int buy, int cap, int[][][] dp) {
        if (ind == n || cap == 0) {
            return 0;
        }
        if (dp[ind][buy][cap] != -1) {
            return dp[ind][buy][cap];
        }

        // Skip the current day
        int profit = getans(prices, n, ind + 1, buy, cap, dp);

        // Buy the stock if possible
        if (buy == 0 && cap > 0) {
            profit = Math.max(profit, -prices[ind] + getans(prices, n, ind + 1, 1, cap - 1, dp));
        }

        // Sell the stock if possible
        if (buy == 1) {
            profit = Math.max(profit, prices[ind] + getans(prices, n, ind + 1, 0, cap, dp));
        }

        // Hold the stock if possible
        if (buy == 1) {
            profit = Math.max(profit, getans(prices, n, ind + 1, 1, cap, dp));
        }

        dp[ind][buy][cap] = profit;
        return profit;
    }
//    tabulation
    static int maxProfit_tabulation(int[] prices) {
        int n = prices.length;

        // Creating a 3D dp array of size [n+1][2][3] initialized to 0
        int[][][] dp = new int[n + 1][2][3];

        // Loop through the dp array, starting from the second last stock (ind=n-1)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap],
                                -prices[ind] + dp[ind + 1][1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }

        // The maximum profit with 2 transactions is stored in dp[0][0][2]
        return dp[0][0][2];
    }
}
