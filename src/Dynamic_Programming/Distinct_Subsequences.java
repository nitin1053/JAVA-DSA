package Dynamic_Programming;

import java.util.Arrays;

import static Dynamic_Programming.Distinct_Subsequences.Solution.prime;

public class Distinct_Subsequences {
//    memorization
    class Solution {
    static int prime = (int) (Math.pow(10, 7) + 7);

    public int numDistinct(String s, String t) {
        int f = s.length();
        int g = t.length();
        int dp[][] = new int[f + 1][g + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return countutil(s, t, f - 1, g - 1, dp);
    }

    static int countutil(String str1, String str2, int ind1, int ind2, int[][] dp) {
        if (ind2 < 0) {
            return 1;
        }
        if (ind1 < 0) {
            return 0;
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }
        if (str1.charAt(ind1) == str2.charAt(ind2)) {
            int leaveOne = countutil(str1, str2, ind1 - 1, ind2 - 1, dp);
            int stay = countutil(str1, str2, ind1 - 1, ind2, dp);
            return dp[ind1][ind2] = (stay + leaveOne) % prime;
        } else {
            return dp[ind1][ind2] = countutil(str1, str2, ind1 - 1, ind2, dp);
        }
    }
}

    public int numDistincttabulation(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the base case: empty string t can be formed from any string s.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the dp array using dynamic programming.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % prime;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
//    finally accepted solution
public int numDistinct(String s, String t) {
    final int m = s.length();
    final int n = t.length();
    long[][] dp = new long[m + 1][n + 1];

    for (int i = 0; i <= m; ++i)
        dp[i][0] = 1;

    for (int i = 1; i <= m; ++i)
        for (int j = 1; j <= n; ++j)
            if (s.charAt(i - 1) == t.charAt(j - 1))
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            else
                dp[i][j] = dp[i - 1][j];

    return (int) dp[m][n];
}
}







