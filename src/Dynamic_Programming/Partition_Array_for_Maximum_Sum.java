package Dynamic_Programming;

import java.util.Arrays;

public class Partition_Array_for_Maximum_Sum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return f(0,arr,k,dp);
    }
    static int f(int ind,int[] nums,int k,int[] dp){
        int n=nums.length;
        if(ind==n){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int len=0;
        int maxi=Integer.MIN_VALUE;
        int maxans=Integer.MIN_VALUE;
        for(int j=ind;j<Math.min(ind+k,n);j++){
            len++;
            maxi=Math.max(maxi,nums[j]);
            int sum=len*maxi+f(j+1,nums,k,dp);
            maxans=Math.max(maxans,sum);
        }
        return dp[ind]=maxans;
    }
//    tabulation
    static int maxSumAfterPartitioning_tabu(int[] num, int k) {
        int n = num.length;
        int[] dp = new int[n + 1];

        // Traverse the input array from right to left
        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;

            // Iterate through the next 'k' elements or remaining elements if less than 'k'.
            for (int j = ind; j < Math.min(ind + k, n); j++) {
                len++;
                maxi = Math.max(maxi, num[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] num = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int maxSum = maxSumAfterPartitioning_tabu(num, k);
        System.out.println("The maximum sum is: " + maxSum);
    }
}
