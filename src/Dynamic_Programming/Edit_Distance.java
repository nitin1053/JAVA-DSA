package Dynamic_Programming;

import java.util.Arrays;

public class Edit_Distance {
    static int edit_dist(String s1,String s2,int i,int j,int[][] dp){
        if (i<0){
            return j+1;
        }
        if (j<0){
            return i+1;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        if (s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=edit_dist(s1,s2,i-1,j-1,dp);
        }
        else {
            return dp[i][j]=1+Math.min(edit_dist(s1,s2,i-1,j-1,dp),Math.min(edit_dist(s1,s2,i,j-1,dp),edit_dist(s1,s2,i-1,j,dp)));
        }
    }
    static int editDistance(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        int[][] dp = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return edit_dist(S1, S2, n - 1, m - 1, dp);
    }
//    tabulation
static int editDistancetabulation(String S1, String S2) {
    int n = S1.length();
    int m = S2.length();

    // Create two arrays to store the previous and current rows of minimum edit distances
    int[] prev = new int[m + 1];
    int[] cur = new int[m + 1];

    // Initialize the first row with their respective indices
    for (int j = 0; j <= m; j++) {
        prev[j] = j;
    }

    // Fill the cur array using a bottom-up approach
    for (int i = 1; i <= n; i++) {
        cur[0] = i;
        for (int j = 1; j <= m; j++) {
            if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                // If the characters match, no edit is needed, so take the value from the diagonal.
                cur[j] = prev[j - 1];
            } else {
                // If the characters don't match, take the minimum of three possibilities:
                // 1. Replace the character in S1 with the character in S2 (diagonal).
                // 2. Delete the character in S1 (left).
                // 3. Insert the character from S2 into S1 (up).
                cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
            }
        }
        // Update prev array to store the current values
        prev = cur.clone();
    }

    return cur[m];
}

}
