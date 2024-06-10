package Dynamic_Programming;
import java.util.Arrays;

public class subset_set_equal_to_target {
    static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        // If the target sum is achieved, return true
        if (target == 0)
            return true;

        // If we have considered all elements but haven't reached the target, return false
        if (ind == 0)
            return arr[0] == target;

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        // Try not taking the current element
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        // Try taking the current element if it doesn't exceed the target
        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);

        // Store the result in the DP table and return whether either option was successful
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    // Main function to check if there exists a subset with a given target sum
    static boolean subsetSumToK(int n, int k, int[] arr) {
        // Create a DP table with dimensions [n][k+1]
        int dp[][] = new int[n][k + 1];

        // Initialize DP table with -1 (unprocessed)
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return subsetSumUtil(n - 1, k, arr, dp);
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }

//    tabualtion
static boolean subsetSumToK2(int n, int k, int[] arr) {
    // Create a boolean DP table with dimensions [n][k+1]
    boolean dp[][] = new boolean[n][k + 1];

    // Initialize the first row of the DP table
    for (int i = 0; i < n; i++) {
        dp[i][0] = true;
    }

    // Initialize the first column of the DP table
    if (arr[0] <= k) {
        dp[0][arr[0]] = true;
    }

    // Fill in the DP table using bottom-up approach
    for (int ind = 1; ind < n; ind++) {
        for (int target = 1; target <= k; target++) {
            // Calculate if the current target can be achieved without taking the current element
            boolean notTaken = dp[ind - 1][target];

            // Calculate if the current target can be achieved by taking the current element
            boolean taken = false;
            if (arr[ind] <= target) {
                taken = dp[ind - 1][target - arr[ind]];
            }

            // Store the result in the DP table
            dp[ind][target] = notTaken || taken;
        }
    }

    // The final result is stored in the bottom-right cell of the DP table
    return dp[n - 1][k];
}

}
