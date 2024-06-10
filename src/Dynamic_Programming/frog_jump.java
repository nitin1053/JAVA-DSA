package Dynamic_Programming;

import java.util.Arrays;

public class frog_jump {
    static int solve(int ind,int[] height,int[] dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne= solve(ind-1, height,dp)+ Math.abs(height[ind]-height[ind-1]);
        if(ind>1)
            jumpTwo = solve(ind-2, height,dp)+ Math.abs(height[ind]-height[ind-2]);

        return dp[ind]=Math.min(jumpOne, jumpTwo);
    }
    public static void main(String args[]) {

        int height[]={30,10,60,10,60,50};
        int n=height.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int ind=1;ind<n;ind++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne= dp[ind-1] + Math.abs(height[ind]-height[ind-1]);
            if(ind>1)
                jumpTwo = dp[ind-2] + Math.abs(height[ind]-height[ind-2]);

            dp[ind]=Math.min(jumpOne, jumpTwo);
        }
        System.out.println(dp[n-1]);
    }


}
