package Dynamic_Programming;

public class Shortest_common_subequence {
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {
            int n = str1.length();
            int m = str2.length();
            int[][] dp = new int[n + 1][m + 1];

            // Fill the first row and column with 0
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 0;
            }
            for (int j = 0; j <= m; j++) {
                dp[0][j] = 0;
            }

            // Fill the dp array using LCS logic
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            // Build the shortest common supersequence using the dp array
            StringBuilder sb = new StringBuilder();
            int i = n, j = m;
            while (i > 0 && j > 0) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    sb.append(str1.charAt(i - 1));
                    i--;
                    j--;
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    sb.append(str1.charAt(i - 1));
                    i--;
                } else {
                    sb.append(str2.charAt(j - 1));
                    j--;
                }
            }

            // Append remaining characters from str1 and str2
            while (i > 0) {
                sb.append(str1.charAt(i - 1));
                i--;
            }
            while (j > 0) {
                sb.append(str2.charAt(j - 1));
                j--;
            }

            // Reverse the final result and return
            return sb.reverse().toString();
        }
    }

}
