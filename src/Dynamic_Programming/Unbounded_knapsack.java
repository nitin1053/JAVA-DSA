package Dynamic_Programming;

import java.util.Arrays;

public class Unbounded_knapsack {
    static int knaputil(int[] wt,int[] val,int ind,int W,int[][] dp){
        if (ind==0){
            return ((int)(W/wt[0]))*val[0];
        }
        if (dp[ind][W]!=-1){
            return dp[ind][W];
        }
        int nottaken=0+knaputil(wt,val,ind-1,W,dp);
        int taken=Integer.MIN_VALUE;
        if (wt[ind]<=W){
            taken=knaputil(wt,val,ind,W-val[ind],dp);
        }
        return Math.max(taken,nottaken);
    }
    static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][W + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the knapsackUtil function to solve the problem
        return knaputil(wt, val, n - 1, W, dp);
    }
//    tabulation
static int unboundedKnapsack__tabulation(int n, int W, int[] val, int[] wt) {
    // Create a 2D array to store results of subproblems
    int[][] dp = new int[n][W + 1];

    // Base condition: Initialize the dp array for the first item
    for (int i = wt[0]; i <= W; i++) {
        dp[0][i] = ((int) i / wt[0]) * val[0];
    }

    // Fill the dp array using dynamic programming
    for (int ind = 1; ind < n; ind++) {
        for (int cap = 0; cap <= W; cap++) {
            // Calculate the maximum value when the current item is not taken
            int notTaken = 0 + dp[ind - 1][cap];

            // Initialize the maximum value when the current item is taken as the minimum integer value
            int taken = Integer.MIN_VALUE;

            // If the weight of the current item is less than or equal to the current capacity (cap),
            // calculate the maximum value when the current item is taken
            if (wt[ind] <= cap)
                taken = val[ind] + dp[ind][cap - wt[ind]];

            // Store the result in the dp array
            dp[ind][cap] = Math.max(notTaken, taken);
        }
    }

    return dp[n - 1][W]; // Return the maximum value that can be obtained
}

}
