package Dynamic_Programming;

import java.util.Arrays;

public class Longest_Common_Subsequence {
//    memeorization
    static int lcsutil(String s1,String s2,int ind1,int ind2,int[][] dp){
        if (ind1<0 || ind2<0){
            return 0;
        }
        if (dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if (s1.charAt(ind1)==s2.charAt(ind2)){
            return 1+lcsutil(s1,s2,ind1-1,ind2-1,dp);
        }
        else {
            return dp[ind1][ind2]=Math.max(lcsutil(s1,s2,ind1,ind2-1,dp),lcsutil(s1,s2,ind1-1,ind2,dp));
        }
    }
    static int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n][m];
        for (int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return lcsutil(s1,s2,n-1,m-1,dp);
    }

    static int lcs_tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with zeros since LCS with an empty string is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using dynamic programming
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m]; // Return the length of the Longest Common Subsequence (LCS)
    }

    public static void main(String args[]) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + lcs(s1, s2));
    }

}
class Printsting_lcs{
    static void lcs(String s1, String s2) {

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for(int ind1=1;ind1<=n;ind1++){
            for(int ind2=1;ind2<=m;ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }

        int len=dp[n][m];
        int i=n;
        int j=m;

        int index = len-1;
        String str="";
        for(int k=1; k<=len;k++){
            str +="$"; // dummy string
        }
        StringBuilder ss= new StringBuilder(s1);
        StringBuilder str2=new StringBuilder(str);
        while(i>0 && j>0){
            if(ss.charAt(i-1) == s2.charAt(j-1)){
                str2.setCharAt(index,ss.charAt(i-1) );
                index--;
                i--;
                j--;
            }
            else if(ss.charAt(i-1)>s2.charAt(j-1)){
                i--;
            }
            else j--;
        }
        System.out.println(str2);
    }

    public static void main(String args[]) {

        String s1= "abcde";
        String s2= "bdgek";

        System.out.print("The Longest Common Subsequence is ");
        lcs(s1,s2);
    }
}
