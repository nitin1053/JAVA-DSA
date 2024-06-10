package Dynamic_Programming;

import java.util.Arrays;
import java.util.Vector;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    static long getmax_profit_util(long[] arr, int ind, int buy, int n, Vector<Vector<Long>> dp) {
        if (ind == n) {
            return 0;
        }
        if (dp.get(ind).get(buy) != -1) {
            return dp.get(ind).get(buy);
        }
        long profit = 0;
        if (buy == 0) {
            profit = Math.max(0 + getmax_profit_util(arr, ind + 1, 0, n, dp),
                    -arr[ind] + getmax_profit_util(arr, ind + 1, 1, n, dp));
        }
        if (buy == 1) {
            profit = Math.max(0 + getmax_profit_util(arr, ind + 1, 1, n, dp),
                    arr[ind] + getmax_profit_util(arr, ind + 1, 0, n, dp));
        }
        dp.get(ind).set(buy, profit);
        return profit;
    }

    static int getmaxprofit(long[] arr, int n) {
        Vector<Vector<Long>> dp = new Vector<>();
        for (int i = 0; i < n; i++) {
            Vector<Long> row = new Vector<>(2);
            row.addAll(Arrays.asList(-1L, -1L));
            dp.add(row);
        }
        if (n == 0) {
            return 0;
        }
        long ans = getmax_profit_util(arr, 0, 0, n, dp);
        return (int) ans;
    }

//    


    class StockProfit {
        // Recursive function to calculate the maximum profit
        static long getMaximumProfitUtil(long[] Arr, int ind, int buy, int n, Vector<Vector<Long>> dp) {
            // Base case
            if (ind == n)
                return 0;

            // If the result is already computed, return it
            if (dp.get(ind).get(buy) != -1)
                return dp.get(ind).get(buy);

            long profit = 0;

            if (buy == 0) { // We can buy the stock
                profit = Math.max(0 + getMaximumProfitUtil(Arr, ind + 1, 0, n, dp),
                        -Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp));
            }

            if (buy == 1) { // We can sell the stock
                profit = Math.max(0 + getMaximumProfitUtil(Arr, ind + 1, 1, n, dp),
                        Arr[ind] + getMaximumProfitUtil(Arr, ind + 1, 0, n, dp));
            }

            // Store the result in the dp table and return it
            dp.get(ind).set(buy, profit);
            return profit;
        }

        // Function to calculate the maximum profit
        static long getMaximumProfit(long[] Arr, int n) {
            // Create a 2D vector for memoization (dp)
            Vector<Vector<Long>> dp = new Vector<>(n);
            for (int i = 0; i < n; i++) {
                Vector<Long> row = new Vector<>(2);
                row.addAll(Arrays.asList(-1L, -1L));
                dp.add(row);
            }

            // Base case: If n is 0, return 0 profit
            if (n == 0)
                return 0;

            // Calculate the maximum profit using the recursive function
            long ans = getMaximumProfitUtil(Arr, 0, 0, n, dp);
            return ans;
        }
//        tabulation
        static long getMaximumProfit2(long[] Arr, int n) {
            // Create a 2D array for dynamic programming with dimensions [n+1][2]
            long[][] dp = new long[n + 1][2];

            // Initialize the entire dp table with -1
            for (long[] row : dp) {
                Arrays.fill(row, -1);
            }

            // Base condition: If we have no stocks to buy or sell, profit is 0
            dp[n][0] = dp[n][1] = 0;

            long profit = 0;

            // Iterate through the array in reverse to calculate the maximum profit
            for (int ind = n - 1; ind >= 0; ind--) {
                for (int buy = 0; buy <= 1; buy++) {
                    if (buy == 0) { // We can buy the stock
                        profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
                    }

                    if (buy == 1) { // We can sell the stock
                        profit = Math.max(0 + dp[ind + 1][1], Arr[ind] + dp[ind + 1][0]);
                    }

                    dp[ind][buy] = profit;
                }
            }
            return dp[0][0]; // The maximum profit is stored at dp[0][0]
        }

        public static void main(String[] args) {
            int n = 6;
            long[] Arr = {7, 1, 5, 3, 6, 4};

            // Calculate and print the maximum profit
            System.out.println("The maximum profit that can be generated is " + getMaximumProfit(Arr, n));
        }
    }

}
