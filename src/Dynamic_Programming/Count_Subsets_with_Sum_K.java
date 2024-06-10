package Dynamic_Programming;

import java.util.Arrays;

public class Count_Subsets_with_Sum_K {



    class TUF {
        // Helper function to find the number of ways to achieve a target sum
        static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
            if (target == 0)
                return 1;

            if (ind == 0)
                return arr[0] == target ? 1 : 0;

            if (dp[ind][target] != -1)
                return dp[ind][target];

            // Calculate the number of ways when the current element is not taken
            int notTaken = findWaysUtil(ind - 1, target, arr, dp);

            // Calculate the number of ways when the current element is taken
            int taken = 0;
            if (arr[ind] <= target)
                taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

            // Store and return the result for the current state
            return dp[ind][target] = notTaken + taken;
        }

        // Main function to find the number of ways to form subsets with a target sum
        static int findWays(int[] num, int k) {
            int n = num.length;
            int dp[][] = new int[n][k + 1];

            for (int row[] : dp)
                Arrays.fill(row, -1);

            return findWaysUtil(n - 1, k, num, dp);
        }

        public static void main(String args[]) {
            int arr[] = {1, 2, 2, 3};
            int k = 3;

            // Calculate and print the number of subsets that sum up to k
            System.out.println("The number of subsets found are " + findWays(arr, k));
        }
    }
    static int findWays(int[] nums, int target) {
        int n = nums.length;

        // Create a 2D DP array to store the number of ways to achieve each target sum
        int[][] dp = new int[n][target + 1];

        // Initialize the first row of the DP array
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // Initialize the first column of the DP array
        if (nums[0] <= target) {
            dp[0][nums[0]] = 1;
        }

        // Fill in the DP array using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int targets = 1; targets <= target; targets++) {
                // Calculate the number of ways when the current element is not taken
                int notTaken = dp[ind - 1][target];

                // Calculate the number of ways when the current element is taken
                int taken = 0;
                if (nums[ind] <= target) {
                    taken = dp[ind - 1][target - nums[ind]];
                }

                // Update the DP array for the current element and target sum
                dp[ind][target] = notTaken + taken;
            }
        }

        // The result is stored in the last cell of the DP array
        return dp[n - 1][target];
    }
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int n = nums.length;
            int[][] dp = new int[n][2001]; // Using 2001 as the range of possible sums [-1000, 1000]
            for (int row[] : dp) {
                Arrays.fill(row, -1);
            }
            return findWayUtil(0, 1000 + target, nums, dp); // Shift the target by 1000 to fit in the array
        }

        static int findWayUtil(int ind, int target, int[] arr, int[][] dp) {
            if (ind == arr.length) {
                return target == 1000 ? 1 : 0; // Check if the shifted target is zero
            }
            if (dp[ind][target] != -1) {
                return dp[ind][target];
            }
            int notTaken = findWayUtil(ind + 1, target - arr[ind], arr, dp);
            int taken = findWayUtil(ind + 1, target + arr[ind], arr, dp);
            return dp[ind][target] = notTaken + taken;
        }
    }
    static int findWaysUtil(int ind, int target,int[] arr, int[][] dp){

        if(ind == 0){
            if(target==0 && arr[0]==0)
                return 2;
            if(target==0 || target == arr[0])
                return 1;
            return 0;
        }

        if(dp[ind][target]!=-1)
            return dp[ind][target];

        int notTaken = findWaysUtil(ind-1,target,arr,dp);

        int taken = 0;
        if(arr[ind]<=target)
            taken = findWaysUtil(ind-1,target-arr[ind],arr,dp);

        return dp[ind][target]= notTaken + taken;
    }

    static int findWays2(int[] num, int k){
        int n = num.length;
        int dp[][]= new int[n][k+1];

        for(int row[]: dp)
            Arrays.fill(row,-1);

        return findWaysUtil(n-1,k,num,dp);
    }


}
