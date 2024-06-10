package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;

public class Burst_Balloons {
    //    recursion approach
    static int maxCoins(int i, int j, ArrayList<Integer> a) {
        if (i > j) return 0;
        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1)
                    + maxCoins(i, ind - 1, a) + maxCoins(ind + 1, j, a);
            maxi = Math.max(maxi, cost);
        }
        return maxi;
    }

    // Wrapper function to calculate the maximum coins
    static int maxCoins(ArrayList<Integer> a) {
        int n = a.size();
        a.add(1);
        a.add(0, 1);
        return maxCoins(1, n, a);
    }

    //  memorization
    static int maxcoin(int i, int j, ArrayList<Integer> a, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int maxi = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1) + maxcoin(i, ind - 1, a, dp) + maxcoin(ind + 1, j, a, dp);
            maxi = Math.max(maxi, cost);


        }
        return dp[i][j] = maxi;


    }

    static int maxcoin(ArrayList<Integer> a) {
        int n = a.size();
        a.add(1);
        a.add(0, 1);
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxcoin(1, n, a, dp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 1, 5, 8));
        int ans = maxCoins(a);
        System.out.println(ans);
    }
//    tabulation
    public int maxcoin_tabu(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 2];
        a[0] = 1;
        a[n + 1] = 1;
        System.arraycopy(nums, 0, a, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                ;
                int maxi = Integer.MIN_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int cost = a[i - 1] * a[ind] * a[j + 1] +
                            dp[i][ind - 1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }

    }
}








