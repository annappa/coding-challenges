package com.kscm.dynamic_programming.begin5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSumSolution {
    public List<Integer> bestSum(int targetSum, int[] nums, List<Integer> bestSum) {
        if(targetSum == 0) {
            return new ArrayList<Integer>();
        }

        if(targetSum < 0) {
            return null;
        }

        for(int num : nums) {
            int remainderSum = targetSum - num;
            List<Integer> remainderRes = bestSum(remainderSum, nums, bestSum);

            if(remainderRes != null) {
                remainderRes.add(num);
                if(bestSum == null || remainderRes.size() < bestSum.size()) {
                    bestSum = remainderRes;
                }
            }
        }
        return bestSum;
    }

    public List<Integer> bestSum_memoization(int targetSum, int[] nums, List<Integer> bestSum, Map<Integer, List<Integer>> mem) {
        if(mem.containsKey(targetSum)) {
            return mem.get(targetSum);
        }

        if(targetSum == 0) {
            return new ArrayList<Integer>();
        }

        if(targetSum < 0) {
            return null;
        }

        for(int num : nums) {
            int remainderSum = targetSum - num;
            List<Integer> remainderRes = bestSum(remainderSum, nums, bestSum);

            if(remainderRes != null) {
                remainderRes.add(num);
                mem.put(targetSum, remainderRes);
                if(bestSum == null || remainderRes.size() < bestSum.size()) {
                    bestSum = remainderRes;
                }
            }
        }
        return bestSum;
    }

    public static void main(String[] args) {
        BestSumSolution bestSumSolution = new BestSumSolution();
        System.out.println("------ Using Recursive Brute Force Approach -------");
        System.out.println(bestSumSolution.bestSum(7, new int[]{5, 3, 4, 7}, null)); //[7]
        System.out.println(bestSumSolution.bestSum(8, new int[]{2, 3, 5}, null)); //[3, 5]

        System.out.println("------ Using Recursive Memoization Approach -------");
        System.out.println(bestSumSolution.bestSum_memoization(7, new int[]{5, 3, 4, 7}, null, new HashMap<Integer, List<Integer>>())); //[7]
        System.out.println(bestSumSolution.bestSum_memoization(8, new int[]{2, 3, 5}, null, new HashMap<Integer, List<Integer>>())); //[3, 5]
    }
}
