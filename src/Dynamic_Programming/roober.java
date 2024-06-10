package Dynamic_Programming;

public class roober {
    public int rob(int[] nums) {
        int l=nums.length;
        if(l==0){
            return 0;
        }
        if(l==1){
            return nums[0];
        }
        int[] dp=new int[l];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<l;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[l-1];


    }
}
