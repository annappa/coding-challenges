package com.kscm.arrays.challenge19;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //int[] candidates = {10,1,2,7,6,1,5};
        int[] candidates = {2,5,2,1,2};
        Arrays.sort(candidates);
        //int[] candidates = {2, 3, 6, 7};
        int target = 5;

        System.out.println(findCombinationsSum(candidates, target));
    }

    public static List<List<Integer>> findCombinationsSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void findCombinations(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result) {

        if(target < 0 ) {
            return;
        }

        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i < candidates.length; i++) {
            // if we are processing the candidate for the first time or
            // if the previous candidate and current candidate are not the same, means skipping the processing for the duplicates
            // Candidates are sorted , check main method
            if(i == start || candidates[i] != candidates[i-1]) {
                list.add(candidates[i]);
                findCombinations(candidates, i+1, target - candidates[i], list, result);
                list.remove(list.size()-1);
            }
        }
    }
}
