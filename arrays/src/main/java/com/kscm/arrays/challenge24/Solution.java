package com.kscm.arrays.challenge24;

import java.util.Arrays;

/*
1. Sort the given array.
2. Find minimum difference of all pairs in linear time in sorted array.
3. Traverse sorted array one more time to print all pairs with minimum difference obtained in step 2.
 */
public class Solution {
    public static void main (String[] args)
    {
        int arr[] = {5, 3, 2, 4, 1};
        int n = arr.length;
        printMinDiffPairs(arr, n);
    }

    static void printMinDiffPairs(int arr[], int n) {
        if (n <= 1)
            return;

        // Sort array elements
        Arrays.sort(arr);

        // Compare differences of adjacent
        // pairs to find the minimum difference.
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i< n-1; i++){
            min = Math.min(min, arr[i+1] - arr[i]);
        }

        // Traverse array again and print all pairs
        // with difference as minDiff.
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n-1; i++){
            if(arr[i+1] - arr[i] == min){
                sb.append("(" + arr[i] + " " + arr[i+1] + "),");
            }
        }
        System.out.println(sb.toString());

    }
}
