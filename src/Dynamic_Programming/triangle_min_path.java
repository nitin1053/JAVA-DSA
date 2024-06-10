package Dynamic_Programming;

import java.util.Arrays;
import java.util.List;

public class triangle_min_path {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        for(int i=row-2;i>=0;i--){
            List<Integer> currow=triangle.get(i);
            for(int j=0;j<currow.size();j++){
                int currele=currow.get(j);
                int minpath=Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+currele;
                currow.set(j,minpath);
            }
        }
        return triangle.get(0).get(0);
    }
    static int minimumPathSumUtil(int i, int j, int[][] triangle, int n, int[][] dp) {
        // Check if the result for the current position (i, j) is already calculated
        if (dp[i][j] != -1)
            return dp[i][j];

        // If we are at the bottom row, return the value in the triangle
        if (i == n - 1)
            return triangle[i][j];

        // Calculate the minimum path sum by recursively considering two possible paths: down and diagonal
        int down = triangle[i][j] + minimumPathSumUtil(i + 1, j, triangle, n, dp);
        int diagonal = triangle[i][j] + minimumPathSumUtil(i + 1, j + 1, triangle, n, dp);

        // Store the result in the dp array and return the minimum of the two paths
        return dp[i][j] = Math.min(down, diagonal);
    }

    // Function to find the minimum path sum in the triangle
    static int minimumPathSum(int[][] triangle, int n) {
        // Create a 2D array to store computed results, initialize with -1
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the utility function to find the minimum path sum starting from the top
        return minimumPathSumUtil(0, 0, triangle, n, dp);
    }
    static int minimumPathSum_tabulation(int[][] triangle, int n) {
        // Create a 2D array to store intermediate results
        int dp[][] = new int[n][n];

        // Initialize the bottom row of dp with the values from the bottom row of the triangle
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }

        // Starting from the second to last row, calculate the minimum path sum for each element
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];

                // Store the minimum of the two paths in dp
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        // The result is stored at the top of dp array
        return dp[0][0];
    }

}
