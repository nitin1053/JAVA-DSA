package Dynamic_Programming;

import java.util.Arrays;

public class Matrix_Chain_Multiplication {
    static int f(int[] arr, int i, int j){

        // base condition
        if(i == j)
            return 0;

        int mini = Integer.MAX_VALUE;

        // partioning loop
        for(int k = i; k<= j-1; k++){

            int ans = f(arr,i,k) + f(arr, k+1,j) + arr[i-1]*arr[k]*arr[j];

            mini = Math.min(mini,ans);

        }

        return mini;
    }


    static int matrixMultiplication(int[] arr, int N){

        int i =1;
        int j = N-1;


        return f(arr,i,j);


    }
    static int f(int arr[], int i, int j, int[][] dp){

        // base condition
        if(i == j)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;

        // partioning loop
        for(int k = i; k<= j-1; k++){

            int ans = f(arr,i,k,dp) + f(arr, k+1,j,dp) + arr[i-1]*arr[k]*arr[j];

            mini = Math.min(mini,ans);

        }

        return mini;
    }

    public static void main(String args[]) {

        int arr[] = {10, 20, 30, 40, 50};

        int n = arr.length;

        System.out.println("The minimum number of operations are "+
                matrix_multiplication_tabu(arr,n));

    }
//    tabulation
    static int matrix_multiplication_tabu(int[] arr, int N){
        int[][] dp=new int[N][N];
        for (int row[]:dp){
            Arrays.fill(row,-1);

        }
        for (int i=0;i<N;i++){
            dp[i][i]=0;
        }
        for (int i=N;i>=1;i--){
            for (int j=i+1;j<N;j++){
                int minoperations=Integer.MAX_VALUE;
                for (int k=i;k<=j-1;k++){
                    int operation=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    minoperations=Math.min(minoperations,operation);
                }
                dp[i][j]=minoperations;
            }
        }
        return dp[1][N-1];

    }


}
