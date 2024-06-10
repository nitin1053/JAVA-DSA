package Dynamic_Programming;
import java.util.Arrays;
public class cherry_pickup {
//    memorization
    static int maxchocolate(int i,int j1,int j2,int n,int m,int[][] grid,int[][][] dp){
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return Integer.MIN_VALUE;
        }
        if(i==n-1){
            if(j1==j2){
                return grid[i][j1];
            }
            return grid[i][j1]+grid[i][j2];
        }
        if (dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        int maxi=Integer.MIN_VALUE;
        for (int di=-1;di<=1;i++){
            for (int dj=-1;dj<=1;i++){
                int ans;
                if (j1==j2){
                    ans=grid[i][j2]+maxchocolate(i+1,j1+di,j2+dj,n,m,grid,dp);

                }
                else {
                    ans=grid[i][j1]+grid[i][j2]+maxchocolate(i+1,j1+di,j2+dj,n,m,grid,dp);

                }
                maxi=Math.max(maxi,ans);
            }
        }
        return dp[i][j1][j2]=maxi;
    }
    static int maximumChocolates(int n, int m, int[][] grid) {
        // Create a 3D array to store computed results
        int dp[][][] = new int[n][m][m];

        // Initialize the dp array with -1
        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }

        // Call the utility function to find the maximum number of chocolates
        return maxchocolate(0, 0, m - 1, n, m, grid, dp);
    }

    public static void main(String args[]) {
        int matrix[][] = {{2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}};
        int n = matrix.length;
        int m = matrix[0].length;

        // Call the maximumChocolates function and print the result
        System.out.println(maximumChocolates(n, m, matrix));
    }
//    tabulation
    static int maximumChocolate(int n, int m, int[][] grid) {
        // Create a 3D array to store computed results
        int dp[][][] = new int[n][m][m];

        // Initialize the dp array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result in the dp array
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        // The final result is stored at the top row (first row) of the dp array
        return dp[0][0][m - 1];
    }
}

