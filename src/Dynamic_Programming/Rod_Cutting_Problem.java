package Dynamic_Programming;// Java recursive solution for Rod cutting problem
import java.io.*;
class Rod_Cutting_Problem{

    /* Returns the best obtainable price for a rod of length
    n and price[] as prices of different pieces */
    static int cutRod(int price[], int index, int n)
    {
        // base case
        if (index == 0) {
            return n * price[0];
        }
        // At any index we have 2 options either
        // cut the rod of this length or not cut
        // it
        int notCut = cutRod(price, index - 1, n);
        int cut = Integer.MIN_VALUE;
        int rod_length = index + 1;

        if (rod_length <= n)
            cut = price[index]
                    + cutRod(price, index, n - rod_length);

        return Math.max(notCut, cut);
    }

//    tabulation
    static int cutRod(int price[],int n)
    {
        int val[] = new int[n+1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,
                        price[j] + val[i-j-1]);
            val[i] = max_val;
        }

        return val[n];
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "
                + cutRod(arr, size - 1, size));
    }
}

// This code is contributed by Lovely Jain
