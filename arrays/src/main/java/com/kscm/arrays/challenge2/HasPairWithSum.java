package com.kscm.arrays.challenge2;

import java.util.HashSet;
import java.util.Set;

public class HasPairWithSum {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 9};
        int[] arr1 = new int[] {1, 2, 4, 4};
        int sum=8;

        System.out.println(hasPairWithSum(arr, sum));
        System.out.println(hasPairWithSum(arr1, sum));

        System.out.println("\nBetter solution now");
        System.out.println("-----------------");
        System.out.println(hasPairWithSum2(arr, sum));
        System.out.println(hasPairWithSum2(arr1, sum));
    }

    //Time complexity O(n^2)
    private static boolean hasPairWithSum(int arr[], int sum) {
        int len =arr.length;
        for(int i=0; i<len;i++){
            for(int j=0; j<len; j++) {
                if(arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    // Time complexity - O(n)
    private static boolean hasPairWithSum2(int arr[], int sum) {
        int len = arr.length;
        Set mySet = new HashSet();

        for(int i=0; i<len; i++) {
            if(mySet.contains(arr[i]))
                return true;

            mySet.add(sum - arr[i]);
        }
        return false;
    }
}

/*
// Naive
function hasPairWithSum(arr, sum){
  var len = arr.length;
  for(var i =0; i<len-1; i++){
     for(var j = i+1;j<len; j++){
        if (arr[i] + arr[j] === sum)
            return true;
     }
  }

  return false;
}

// Better
function hasPairWithSum2(arr, sum){
  const mySet = new Set();
  const len = arr.length;
  for (let i = 0; i < len; i++){
    if (mySet.has(arr[i])) {
      return true;
    }
    mySet.add(sum - arr[i]);
  }
  return false;
}

hasPairWithSum2([6,4,3,2,1,7], 9)
 */
