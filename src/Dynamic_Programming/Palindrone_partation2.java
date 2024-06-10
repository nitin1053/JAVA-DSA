package Dynamic_Programming;

import java.util.Arrays;

public class Palindrone_partation2 {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return f(0,n,s,dp)-1;

    }
    static boolean ispalindrone(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;

            }
            i++;
            j--;
        }
        return true;
    }
    static int f(int i, int n, String s, int[] dp) {
        if (i == n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int minCost = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) { // Start the loop from i
            if (ispalindrone(i, j, s)) {
                int cost = 1 + f(j + 1, n, s, dp); // Increment the cut count by 1
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }
//    tabulation


    static int palindromePartitioning(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            // String[i...j]
            for (int j = i; j < n; j++) {
                if (ispalindrone(i, j, str)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
    }

    public static void main(String[] args) {
        String str = "BABABCBADCEDE";
        int partitions = palindromePartitioning(str);
        System.out.println("The minimum number of partitions: " + partitions);
    }
}
