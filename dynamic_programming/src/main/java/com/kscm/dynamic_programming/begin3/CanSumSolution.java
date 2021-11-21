package com.kscm.dynamic_programming.begin3;

import java.util.HashMap;
import java.util.Map;

public class CanSumSolution {
    //if m is the targetSum and n array length
    //Time: O(n^m)
    //Space: O(m)
    public boolean canSum(int targetSum, int[] arr) {
        //base condition
        if(targetSum == 0) {
            return true;
        }
        //base condition
        if(targetSum < 0) {
            return false;
        }

        for(int num : arr) {
            int remainderSum = targetSum - num;
            if(canSum(remainderSum, arr)) {
                // we have found the target, so return "true" to the calling parent
                return true;
            }
            // Since we have already found the result, we are not handling else condition (false) of other possible routes(total n possible routes)
        }

        // All posible routes are tracked and we didnt find the result. so returning false as final result
        return false;
    }

    // Time: O(m*n)
    // Space: O(m)
    public boolean canSum_memoization(int targetSum, int[] arr, Map<Integer, Boolean> memo) {
        if(memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        //base condition
        if(targetSum == 0) {
            return true;
        }
        //base condition
        if(targetSum < 0) {
            return false;
        }

        for(int num : arr) {
            int remainderSum = targetSum - num;
            if(canSum_memoization(remainderSum, arr, memo)) {
                memo.put(targetSum, true);
                // we have found the target, so return "true" to the calling parent
                return true;
            }
            // Since we have already found the result, we are not handling else condition (false) of other possible routes(total n possible routes)
        }

        memo.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        CanSumSolution canSumSolution = new CanSumSolution();
        System.out.println("------ Brute Force Recursive Approach --------");
        System.out.println(canSumSolution.canSum(7, new int[]{5, 3, 4, 7})); // true
        System.out.println(canSumSolution.canSum(7, new int[]{2, 4})); // false

        System.out.println("------ Recursive Memoization Approach --------");
        System.out.println(canSumSolution.canSum_memoization(7, new int[]{5, 3, 4, 7}, new HashMap<Integer, Boolean>())); // true
        System.out.println(canSumSolution.canSum_memoization(7, new int[]{2, 4}, new HashMap<Integer, Boolean>())); // false
    }
}

