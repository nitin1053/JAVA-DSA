package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Minimum_cost_to_cut_the_stick {
    static int cost(int n, int c, ArrayList<Integer> cuts){
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);
        return f1(1,c,cuts);
    }
//    recursion
    static int f1(int i,int j,ArrayList<Integer> cuts){
        if (i>j){
            return 0;
        }
        int mini=Integer.MAX_VALUE;
        for (int ind=i;i<=j;ind++){
            int ans=cuts.get(j+1)-cuts.get(i-1)+f1(i,ind-1,cuts)+f1(ind+1,j,cuts);
            mini=Math.min(ans,mini);
        }

        return mini;
    }
//    memorizarion
    static int f2(int i,int j,ArrayList<Integer> cuts,int[][] dp){
        if (i>j){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int mini=Integer.MAX_VALUE;
        for (int ind=0;i<=j;ind++){
            int ans=cuts.get(j+1)-cuts.get(i-1)+f2(i,ind-1,cuts,dp)+f2(ind+1,j,cuts,dp);
            mini=Math.min(mini,ans);
        }
        return dp[i][j]=mini;
    }
    static int cost2(int n, int c, ArrayList<Integer> cuts) {
        // Modify the cuts array
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        int[][] dp = new int[c + 1][c + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f2(1, c, cuts, dp);
    }

//    tabulation


    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        // Modify the cuts array
        int[] modifiedCuts = Arrays.copyOf(cuts, c + 2);
        modifiedCuts[c] = n;
        modifiedCuts[c + 1] = 0;
        Arrays.sort(modifiedCuts);

        int[][] dp = new int[c + 2][c + 2];

        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int ans = modifiedCuts[j + 1] - modifiedCuts[i - 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, ans);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];
    }
//    static int cost(int n, int c, ArrayList<Integer> cuts) {
//        // Modify the cuts array
//        cuts.add(n);
//        cuts.add(0);
//        Collections.sort(cuts);
//
//        int[][] dp = new int[c + 2][c + 2];
//
//        for (int[] row : dp) {
//            Arrays.fill(row, 0);
//        }
//
//        for (int i = c; i >= 1; i--) {
//            for (int j = 1; j <= c; j++) {
//                if (i > j) continue;
//
//                int mini = Integer.MAX_VALUE;
//
//                for (int ind = i; ind <= j; ind++) {
//                    int ans = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
//                    mini = Math.min(mini, ans);
//                }
//
//                dp[i][j] = mini;
//            }
//        }
//
//        return dp[1][c];
//    } code by take u forward



    public static void main(String[] args) {
        ArrayList<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
        int c = cuts.size();
        int n = 7;

        System.out.println("The minimum cost incurred: " + cost(n, c, cuts));
    }
}
