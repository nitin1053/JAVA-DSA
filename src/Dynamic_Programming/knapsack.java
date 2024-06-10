package Dynamic_Programming;

import java.util.Arrays;

public class knapsack {
    static int knapsackutil(int[] wt,int[] val,int ind,int W,int[][] dp){
        if(ind==0) {
            if (wt[0] <= W) {
                return val[0];
            }
            else{
                return 0;
            }
        }
        if (dp[ind][W]!=-1){
            return dp[ind][W];
        }
        int nottaken=0+knapsackutil(wt,val,ind-1,W,dp);
        int taken=Integer.MIN_VALUE;
        if (wt[ind]<=W){
            taken=val[ind]+knapsackutil(wt,val,ind-1,W-wt[ind],dp);
        }
        dp[ind][W]=Math.max(nottaken,taken);
        return dp[ind][W];
    }
    static int knapsack(int[] wt,int[] val,int n,int W){
        int dp[][]=new int[n][W+1];
        for (int row[]:dp){
            Arrays.fill(row,-1);
        }
        return knapsackutil(wt,val,n-1,W,dp);
    }
    public static void main(String args[]) {
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;
        int n = wt.length;

        // Calculate and print the maximum value of items the thief can steal
        System.out.println("The Maximum value of items the thief can steal is " + knapsack(wt, val, n, W));
    }


}
