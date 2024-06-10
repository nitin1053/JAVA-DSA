package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Longest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums){
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp=new int[n];
        int[] prevind=new int[n];
        Arrays.fill(dp,1); // Corrected
        Arrays.fill(prevind,-1); // Corrected
        int maxindex=0;
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if (nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    prevind[i]=j;
                }
            }
            if (dp[i] > dp[maxindex]) { // Update maxIndex
                maxindex = i;
            }
        }
        List<Integer> result=new ArrayList<>();
        int index=maxindex;
        while (index!=-1){
            result.add(nums[index]);
            index=prevind[index];
        }
        return result;
    }
}
