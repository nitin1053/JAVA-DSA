package Dynamic_Programming;
import java.util.Arrays;

public class grid_min_path_sum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Create a memoization array to store computed values
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return minPathSumHelper(m - 1, n - 1, grid, memo);
    }

    private int minPathSumHelper(int i, int j, int[][] grid, int[][] memo) {
        // Base cases
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        // Check if the value is already computed and stored in the memoization array
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Recursive cases
        int fromTop = minPathSumHelper(i - 1, j, grid, memo);
        int fromLeft = minPathSumHelper(i, j - 1, grid, memo);

        // Calculate the minimum path sum and store in the memoization array
        memo[i][j] = grid[i][j] + Math.min(fromTop, fromLeft);
        return memo[i][j];
    }
//    tabulation
static int minSumPath(int n, int m, int[][] matrix) {
    int dp[][] = new int[n][m];

    // Iterate through the matrix
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (i == 0 && j == 0)
                dp[i][j] = matrix[i][j]; // If we're at the top-left cell, the minimum sum is its value
            else {
                int up = matrix[i][j];
                if (i > 0)
                    up += dp[i - 1][j]; // Add the value from above if it's not out of bounds
                else
                    up += (int) Math.pow(10, 9); // Add a large value if out of bounds in the up direction

                int left = matrix[i][j];
                if (j > 0)
                    left += dp[i][j - 1]; // Add the value from the left if it's not out of bounds
                else
                    left += (int) Math.pow(10, 9); // Add a large value if out of bounds in the left direction

                // Store the minimum of the two possible paths
                dp[i][j] = Math.min(up, left);
            }
        }
    }

    // The final result is stored in the bottom-right cell of the DP matrix
    return dp[n - 1][m - 1];
}
}
