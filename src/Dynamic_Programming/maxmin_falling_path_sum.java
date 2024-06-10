package Dynamic_Programming;
import java.util.Arrays;
public class maxmin_falling_path_sum {
    static int getMaxUtil(int i, int j, int m, int[][] matrix, int[][] dp) {
        // Base Conditions
        if (j < 0 || j >= m)
            return (int) Math.pow(-10, 9);
        if (i == 0)
            return matrix[0][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate three possible paths: moving up, left diagonal, and right diagonal
        int up = matrix[i][j] + getMaxUtil(i - 1, j, m, matrix, dp);
        int leftDiagonal = matrix[i][j] + getMaxUtil(i - 1, j - 1, m, matrix, dp);
        int rightDiagonal = matrix[i][j] + getMaxUtil(i - 1, j + 1, m, matrix, dp);

        // Store the maximum of the three paths in dp
        return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }

    // Function to find the maximum path sum in the matrix
    static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        int maxi = Integer.MIN_VALUE;

        // For each starting column, find the maximum path sum and update maxi
        for (int j = 0; j < m; j++) {
            int ans = getMaxUtil(n - 1, j, m, matrix, dp);
            maxi = Math.max(maxi, ans);
        }

        return maxi;
    }

    public static void main(String args[]) {
        int matrix[][] = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};

        // Call the getMaxPathSum function and print the result
        System.out.println(getMaxPathSum(matrix));
    }
    static int getMaxPathSum_tabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the maximum path sum for each cell in the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(-10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(-10, 9);
                }

                // Store the maximum of the three paths in dp
                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        // Find the maximum value in the last row of dp
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }

        return maxi;
    }

}
