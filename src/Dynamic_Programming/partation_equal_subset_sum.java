package Dynamic_Programming;

import java.util.Arrays;
public class partation_equal_subset_sum {
    class Solution {
        public boolean canPartition(int[] nums) {
            int n=nums.length;
            int totsum=0;
            for(int i=0;i<n;i++){
                totsum+=nums[i];
            }
            if(totsum%2==1){
                return false;
            }
            else{
                int k=totsum/2;
                int dp[][]=new int[n][k+1];
                for(int row[]:dp){
                    Arrays.fill(row,-1);
                }
                return subsetsumutil(n-1,k,nums,dp);
            }

        }
        static boolean subsetsumutil(int ind,int target,int arr[],int[][] dp){
            if(target==0){
                return true;
            }
            if(ind==0){
                return arr[0]==target;
            }
            if(dp[ind][target]!=-1){
                return dp[ind][target]==0 ? false:true;
            }
            boolean nottaken=subsetsumutil(ind-1,target,arr,dp);
            boolean taken=false;
            if(arr[ind]<=target){
                taken=subsetsumutil(ind-1,target-arr[ind],arr,dp);
            }
            dp[ind][target]=nottaken || taken ? 1 : 0;
            return nottaken || taken;
        }

    }
}
