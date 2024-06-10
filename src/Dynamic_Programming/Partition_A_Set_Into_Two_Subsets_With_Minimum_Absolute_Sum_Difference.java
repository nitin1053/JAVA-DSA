package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;

public class Partition_A_Set_Into_Two_Subsets_With_Minimum_Absolute_Sum_Difference {
    static int minsubsetdiff(ArrayList<Integer> arr,int n){
        int totsum=0;
        for(int i=0;i<n;i++){
            totsum += arr.get(i);
        }
        boolean[][] dp=new boolean[n][totsum+1];
        for (int i=0;i<=totsum;i++){
            dp[0][i]=(i== arr.get(0));
        }
        for (int ind=1;ind<n;ind++){
            for (int target=0;target<=totsum;target++){
                boolean nottaken=dp[ind-1][target];

                boolean taken=false;
                if (arr.get(ind)<=target){
                    taken=dp[ind-1][target-arr.get(ind)];
                }
                dp[ind][target]=nottaken || taken;
            }
        }
        int mini=Integer.MAX_VALUE;
        for (int i=0;i<totsum;i++){
            if (dp[n-1][i]){
                int diff=Math.abs(i-(totsum-i));
                mini=Math.min(mini,diff);
            }
        }
        return mini;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        int n = arr.size();

        // Calculate and print the minimum absolute difference
        System.out.println("The minimum absolute difference is: " + minsubsetdiff(arr, n));
    }

}
