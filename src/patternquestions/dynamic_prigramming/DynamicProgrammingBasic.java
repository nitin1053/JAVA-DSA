package patternquestions.dynamic_prigramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicProgrammingBasic {

    public static void main(String[] args) {

        int n = 18;
        int a[] = {7, 5, 1};

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans = minCoins(n, a, dp);
        System.out.println(ans);

        for(int x: dp) {
            System.out.print(x+" ");
        }
    }

    static int minCoins(int n, int a[], int dp[]) {

        if(n == 0) return 0;

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i<a.length; i++) {
            if(n-a[i] >= 0) {
                int subAns = 0;
                if(dp[n-a[i]] != -1) {
                    subAns = dp[n-a[i]];
                } else {
                    subAns = minCoins(n-a[i], a, dp);
                }
                if(subAns != Integer.MAX_VALUE &&
                        subAns + 1 < ans) {
                    ans = subAns + 1;
                }
            }
        }
        return dp[n] = ans;
    }
}

class Longest_common_subsequence{
    static int lcs(int m,int n,String a,String b){
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return(lcsUtil(m,n,a,b,dp));
    }
    static int lcsUtil(int m,int n,String a,String b,int dp[][]){
        if(m==0 || n==0){
            return 0;
        }
        if(dp[m][n]!=1){
            return dp[m][n];
        }
        if(a.charAt(m-1)==b.charAt(n-1)){
            return dp[m][n]= 1+(lcs(m-1,n-1,a,b));
        }
        else{
            return dp[m][n]=Math.max(lcsUtil(m-1,n,a,b,dp),lcsUtil(m,n-1,a,b,dp));
        }
    }
    public static void main(String[] args){


    }
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void markRow(int[][] matrix, int n, int m, int row) {
        for (int j = 0; j < m; j++) {
            if (matrix[row][j] != 0) {
                matrix[row][j] = -1;
            }
        }
    }

    static void markCol(int[][] matrix, int n, int m, int col) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = -1;
            }
        }
    }
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowsToZero = new boolean[m];
        boolean[] colsToZero = new boolean[n];

        // Find rows and columns that need to be zeroed
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowsToZero[i] = true;
                    colsToZero[j] = true;
                }
            }
        }

        // Zero out rows
        for (int i = 0; i < m; i++) {
            if (rowsToZero[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero out columns
        for (int j = 0; j < n; j++) {
            if (colsToZero[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

