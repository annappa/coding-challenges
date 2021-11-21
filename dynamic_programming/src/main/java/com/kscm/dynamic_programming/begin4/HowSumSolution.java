package com.kscm.dynamic_programming.begin4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSumSolution {
    public List<Integer> howSum(int targetSum, int[] nums) {
        if(targetSum == 0) {
            return new ArrayList<Integer>();
        }

        if(targetSum < 0) {
            return null;
        }

        for(int num : nums) {
            int remainderSum = targetSum - num;
            List<Integer> remainderResult = howSum(remainderSum, nums);
            if(remainderResult != null) {
                remainderResult.add(num);
                return remainderResult;
            }
        }
        return null;
    }

    public List<Integer> howSum_memoization(int targetSum, int[] nums, Map<Integer, List<Integer>> memo) {
        if(memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }

        if(targetSum == 0) {
            return new ArrayList<Integer>();
        }

        if(targetSum < 0) {
            return null;
        }

        for(int num : nums) {
            int remainderSum = targetSum - num;
            List<Integer> remainderResult = howSum(remainderSum, nums);
            if(remainderResult != null) {
                remainderResult.add(num);
                memo.put(targetSum, remainderResult);
                return remainderResult;
            }
        }

        memo.put(targetSum, null);
        return null;
    }

    public static void main(String[] args) {
        HowSumSolution howSumSolution = new HowSumSolution();
        System.out.println("-------- Using Recursive Approach ------");
        System.out.println(howSumSolution.howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSumSolution.howSum(7, new int[]{2, 4}));

        System.out.println("-------- Using Recursive Memoization Approach ------");
        System.out.println(howSumSolution.howSum_memoization(7, new int[]{5, 3, 4, 7}, new HashMap<Integer, List<Integer>>()));
        System.out.println(howSumSolution.howSum_memoization(7, new int[]{2, 4}, new HashMap<Integer, List<Integer>>()));
    }
}
