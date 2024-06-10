package Dynamic_Programming;
import java.util.Arrays;
public class Unique_path_grids {
//    memorization approach
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);

        }
        return uniquePathsprocess(m-1,n-1,dp);
    }
    public int uniquePathsprocess(int m, int n,int[][] dp) {

        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int left=uniquePathsprocess(m-1,n,dp);
        int up=uniquePathsprocess(m,n-1,dp);
        return dp[m][n]=up+left;

    }
//    tabulation approach
    static int counttabualtion(int m,int n,int[][] dp){
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                int up=0;
                int left=0;
                if(i>0){
                    up=dp[i-1][j];
                }
                if(j>0){
                    left=dp[i][j-1];
                }
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePaths2(int m, int n) {
        int dp[][]=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);

        }
        return counttabualtion(m-1,n-1,dp);
    }


}
