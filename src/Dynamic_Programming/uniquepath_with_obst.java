package Dynamic_Programming;
import java.util.Arrays;
public class uniquepath_with_obst {


    public class Solution {
//        memorization
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            return uniquePathsWithObstacles(m, n, obstacleGrid);
        }

        private int uniquePathsWithObstacles(int m, int n, int[][] maze) {
            int dp[][] = new int[m][n];
            for (int row[] : dp) {
                Arrays.fill(row, 0); // Initialize with 0 instead of -1
            }
            return mazeObstaclesUtil(m - 1, n - 1, maze, dp);
        }

        public int mazeObstaclesUtil(int m, int n, int[][] maze, int[][] dp) {
            if (m >= 0 && n >= 0 && maze[m][n] == 1) {
                return 0; // Obstacle encountered
            }
            if (m == 0 && n == 0) {
                return 1;
            }
            if (m < 0 || n < 0) {
                return 0;
            }
            if (dp[m][n] != 0) {
                return dp[m][n];
            }
            int up = mazeObstaclesUtil(m - 1, n, maze, dp);
            int left = mazeObstaclesUtil(m, n - 1, maze, dp);
            return dp[m][n] = up + left;
        }
    }
//    tabulization
    static int mazeObstaclesUtil(int n, int m, int[][] maze, int[][] dp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Base conditions
                if (i > 0 && j > 0 && maze[i][j] == -1) {
                    dp[i][j] = 0; // If there's an obstacle, no paths can go through here.
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1; // There's one valid path to the start cell.
                    continue;
                }

                int up = 0;
                int left = 0;

                // Check if moving up is possible
                if (i > 0)
                    up = dp[i - 1][j];

                // Check if moving left is possible
                if (j > 0)
                    left = dp[i][j - 1];

                // Calculate the number of paths by adding paths from above and from the left
                dp[i][j] = up + left;
            }
        }

        // The final result is stored in the bottom-right cell of the DP matrix
        return dp[n - 1][m - 1];
    }

    // Main function to calculate the number of paths through the maze
    static int mazeObstacles(int n, int m, int[][] maze) {
        int dp[][] = new int[n][m];

        // Initialize the DP matrix with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the helper function starting from the top-left cell
        return mazeObstaclesUtil(n, m, maze, dp);
    }

    public static void main(String args[]) {
        // Define the maze
        int[][] maze = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };

        int n = maze.length;
        int m = maze[0].length;

        // Calculate and print the number of paths through the maze
        System.out.println(mazeObstacles(n, m, maze));
    }

}
