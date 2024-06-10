package Dynamic_Programming;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return LISutil(nums, n, 0, -1, dp);
    }

    private int LISutil(int[] nums, int n, int ind, int prev_ind, int[][] dp) {
        if (ind == n) {
            return 0;
        }
        if (dp[ind][prev_ind + 1] != -1) {
            return dp[ind][prev_ind + 1];
        }
        int not_take = LISutil(nums, n, ind + 1, prev_ind, dp);
        int take = 0;
        if (prev_ind == -1 || nums[ind] > nums[prev_ind]) {
            take = 1 + LISutil(nums, n, ind + 1, ind, dp);
        }
        dp[ind][prev_ind + 1] = Math.max(not_take, take);
        return dp[ind][prev_ind + 1];
    }
    static int longestIncreasingSubsequence(int arr[], int n){

        int dp[][]=new int[n+1][n+1];

        for(int ind = n-1; ind>=0; ind --){
            for (int prev_index = ind-1; prev_index >=-1; prev_index --){

                int notTake = 0 + dp[ind+1][prev_index +1];

                int take = 0;

                if(prev_index == -1 || arr[ind] > arr[prev_index]){

                    take = 1 + dp[ind+1][ind+1];
                }

                dp[ind][prev_index+1] = Math.max(notTake,take);

            }
        }

        return dp[0][0];
    }

    public static void main(String args[]) {

        int arr[] = {10,9,2,5,3,7,101,18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is"+longestIncreasingSubsequence(arr,n));

    }
}
