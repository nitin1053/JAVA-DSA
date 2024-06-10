package Dynamic_Programming;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_VI {
    static int getAns(int[] Arr, int ind, int buy, int n, int fee, int[][] dp) {
        // Base case
        if (ind == n) {
            return 0;
        }

        // If the result is already calculated, return it
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        int profit = 0;

        if (buy == 0) { // We can buy the stock
            profit = Math.max(0 + getAns(Arr, ind + 1, 0, n, fee, dp), -Arr[ind] + getAns(Arr, ind + 1, 1, n, fee, dp));
        }

        if (buy == 1) { // We can sell the stock
            profit = Math.max(0 + getAns(Arr, ind + 1, 1, n, fee, dp), Arr[ind] - fee + getAns(Arr, ind + 1, 0, n, fee, dp));
        }

        // Store the result in dp and return it
        dp[ind][buy] = profit;
        return profit;
    }

    // Function to calculate the maximum profit with a transaction fee
    static int maximumProfit(int n, int fee, int[] Arr) {
        int dp[][] = new int[n][2];

        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        if (n == 0) {
            return 0;
        }

        int ans = getAns(Arr, 0, 0, n, fee, dp);
        return ans;
    }
//    tabulation
    static int maximumProfit_tabulation(int n, int fee, int[] Arr) {
        // Handle the base case when n is 0
        if (n == 0) {
            return 0;
        }

        int dp[][] = new int[n + 1][2];

        // Iterate through the array backwards
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], Arr[ind] - fee + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        // The maximum profit is stored in dp[0][0]
        return dp[0][0];
    }

    public static void main(String args[]) {
        int prices[] = {1, 3, 2, 8, 4, 9};
        int n = prices.length;
        int fee = 2;

        System.out.println("The maximum profit that can be generated is " + maximumProfit(n, fee, prices));
    }

}
