package Dynamic_Programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Longest_Bitonic_Subsequence {
    static int Longest_bitonic_subsequence(int[] arr,int n){
        int[] dp1=new int[n];
        int[] dp2=new int[n];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        for (int i=0;i<n;i++){
            for (int prev=0;prev<1;prev++){
                if (arr[prev]<arr[i]){
                    dp1[i]=Math.max(dp1[i],1+dp1[prev]);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int prevIndex = n - 1; prevIndex > i; prevIndex--) {
                if (arr[prevIndex] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[prevIndex]);
                }
            }
        }
        int maxi=-1;
        for (int i=0;i<n;i++){
            maxi=Math.max(maxi,dp1[i]+dp2[i]-1);
        }
        return maxi;
    }
    public static void main(String[] args) {
        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;

        System.out.println("The length of the longest bitonic subsequence is " +
                Longest_bitonic_subsequence(arr, n));
    }
}
