package Dynamic_Programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Minimum_Coins {
    static int minEle(int[] arr,int T){
        int n=arr.length;
        int[][]dp=new int[n][T+1];
        for (int row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans=minelement(arr,n-1,T,dp);
        if (ans>Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    static int minelement(int[] arr,int ind,int T,int[][] dp){

        if (ind==0){
            if (T % arr[0]==0){
                return T/arr[0];
            }
            else{
                return Integer.MAX_VALUE;
            }
        }
        if (dp[ind][T]!=-1){
            return dp[ind][T];
        }
        int nottaken=0+minelement(arr,ind-1,T,dp);
        int taken=Integer.MAX_VALUE;
        if (arr[ind]<T){
            taken=1+minelement(arr,ind,T-arr[ind],dp);
        }
        return dp[ind][T]=Math.min(nottaken,taken);

    }
//    tabulation
static int minimumElements(int[] arr, int T) {
    int n = arr.length;

    // Create a 2D array to store results of subproblems
    int dp[][] = new int[n][T + 1];

    // Initialize the dp array for the first element of the array
    for (int i = 0; i <= T; i++) {
        if (i % arr[0] == 0)
            dp[0][i] = i / arr[0];
        else
            dp[0][i] = (int) Math.pow(10, 9);
    }

    // Fill the dp array using dynamic programming
    for (int ind = 1; ind < n; ind++) {
        for (int target = 0; target <= T; target++) {
            int notTake = 0 + dp[ind - 1][target];
            int take = (int) Math.pow(10, 9);

            // If the current element is less than or equal to the target, calculate 'take'
            if (arr[ind] <= target)
                take = 1 + dp[ind][target - arr[ind]];

            // Store the minimum result in the dp array
            dp[ind][target] = Math.min(notTake, take);
        }
    }

    // Get the minimum number of elements needed for the target sum
    int ans = dp[n - 1][T];

    // If it's not possible to achieve the target sum, return -1
    if (ans >= (int) Math.pow(10, 9))
        return -1;
    return ans;
}
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int T = 7;

        // Call the minimumElements function and print the result
        System.out.println("The minimum number of coins required to form the target sum is " + minEle(arr, T));
    }
}
