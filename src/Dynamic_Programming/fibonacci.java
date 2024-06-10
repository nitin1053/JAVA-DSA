package Dynamic_Programming;

import java.util.Arrays;

public class fibonacci {
    static int fibo(int number){
        int a=0;
        int b=1,c;
        ;
        if(number==0){
            return a;
        }
        for (int i=2;i<=number;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return b;

    }
    public static void main(String[] args){
        int n=10;
        System.out.println(fibo(n));
    }
}
// otimized java dp approach

class fibo_dp{
    static int function(int n,int[] dp){
        if (n<=1){
            return n;
        }
        if (dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=function(n-1,dp)+function(n-2,dp);
    }

    public static void main(String[] args){
        int n=10;
        int dp[] =new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(function(n,dp));
    }
}