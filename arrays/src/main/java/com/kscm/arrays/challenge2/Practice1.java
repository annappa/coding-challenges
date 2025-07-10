package com.kscm.arrays.challenge2;

import java.util.HashSet;
import java.util.Set;

public class Practice1 {

    public static void main(String[] args) {
        //int[] arr1 = new int[]{1, 2, 3, 9};
        int[] arr1 = new int[]{1, 2, 4, 4};
        int sum = 8;
        //System.out.println(hasPairsEqualToSumBFS(arr1, sum));
        System.out.println(hasPairsEqualToSum(arr1, sum));
    }

    private static boolean hasPairsEqualToSumBFS(int[] arr, int sum) {
        for(int i=0; i<arr.length;i ++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPairsEqualToSum(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        set.add(arr[0]);
        for(int i=0; i < arr.length; i++) {
            if(set.contains(sum - arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }
}
