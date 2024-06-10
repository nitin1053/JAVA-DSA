package Dynamic_Programming;
import java.util.*;

public class stairs {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
}




class TUF {
    // Recursive function to calculate the minimum cost to reach the end
    // from a given index with at most 'k' jumps.
    static int solveUtil(int ind, int[] height, int[] dp, int k) {
        // Base case: If we are at the beginning (index 0), no cost is needed.
        if (ind == 0)
            return 0;

        // If the result for this index has been previously calculated, return it.
        if (dp[ind] != -1)
            return dp[ind];

        int mmSteps = Integer.MAX_VALUE;

        // Loop to try all possible jumps from '1' to 'k'
        for (int j = 1; j <= k; j++) {
            // Ensure that we do not jump beyond the beginning of the array
            if (ind - j >= 0) {
                // Calculate the cost for this jump and update mmSteps with the minimum cost
                int jump = solveUtil(ind - j, height, dp, k) + Math.abs(height[ind] - height[ind - j]);
                mmSteps = Math.min(jump, mmSteps);
            }
        }

        // Store the minimum cost for this index in the dp array and return it.
        return dp[ind] = mmSteps;
    }

    // Function to find the minimum cost to reach the end of the array
    static int solve(int n, int[] height, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // Initialize a memoization array to store calculated results
        return solveUtil(n - 1, height, dp, k); // Start the recursion from the last index
    }

    public static void main(String args[]) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;
        int k = 2;
        System.out.println(solve(n, height, k)); // Print the result of the solve function
    }
}


class TUF2 {
    // Function to find the minimum cost to reach the end using at most 'k' jumps
    static int solveUtil(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;

        // Loop through the array to fill in the dp array
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            // Loop to try all possible jumps from '1' to 'k'
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1]; // The result is stored in the last element of dp
    }

    // Function to find the minimum cost to reach the end of the array
    static int solve(int n, int[] height, int k) {
        int[] dp = new int[n]; // Initialize a memoization array to store calculated results
        Arrays.fill(dp, -1);
        return solveUtil(n, height, dp, k);
    }

    public static void main(String args[]) {
        int height[] = {30, 10, 60, 10, 60, 50};
        int n = height.length;
        int k = 2;
        System.out.println(solve(n, height, k)); // Print the result of the solve function
    }
}


