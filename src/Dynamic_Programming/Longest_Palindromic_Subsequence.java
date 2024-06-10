package Dynamic_Programming;

import java.util.Arrays;

public class Longest_Palindromic_Subsequence {
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store the LCS lengths
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using a bottom-up approach
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }

    // Function to find the length of the Longest Palindromic Subsequence
    static int longestPalindromeSubsequence(String s) {
        // Create a reversed version of the input string
        String reversed = new StringBuilder(s).reverse().toString();

        // Calculate the LCS of the original string and its reverse
        return lcs(s, reversed);
    }

    public static void main(String args[]) {
        String s = "bbabcbcab";

        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(longestPalindromeSubsequence(s));
    }
}
