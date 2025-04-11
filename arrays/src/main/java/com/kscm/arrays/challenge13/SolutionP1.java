package com.kscm.arrays.challenge13;

import java.util.Arrays;

public class SolutionP1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        // {7, 1, 2, 3, 4, 5, 6}, {6,7,1, 2, 3, 4, 5}, {5, 6, 7, 1, 2, 3, 4}
        int k=3;
        rotateArray(arr, k);
        rotateArray2(arr, k);
    }

    //Time: O(n)
    //Space: O(n)
    private static void rotateArray(int[] arr, int k) {
        int n= arr.length; //7
        int[] resArr = new int[arr.length];
        int resI=0;
        for(int i=n-k; i<n; i++) { // 7-3 =4
            resArr[resI++] = arr[i];
        }

        for(int j=0; j<n-k; j++) {
            resArr[resI++] = arr[j];
        }

        System.out.println(Arrays.toString(resArr));
    }


    private static void rotateArray2(int[] arr, int k) {
        //[1, 2, 3, 4, 5, 6, 7]
        //[7, 6, 5, 4, 3, 2, 1]
        //[5, 6, 7, 4, 3, 2, 1]
        //[5, 6, 7, 1, 2, 3, 4]

        reverseArray(arr, 0, arr.length-1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}