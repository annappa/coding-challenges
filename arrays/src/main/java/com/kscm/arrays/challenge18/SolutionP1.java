package com.kscm.arrays.challenge18;

import java.util.ArrayList;
import java.util.List;

public class SolutionP1 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 8;

        System.out.println(findCombinationsSum(candidates,  target));
    }

    public static List<List<Integer>> findCombinationsSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void findCombinations(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result) {
        //we could not find the combination , so return and last element will be removed at line # 33
        if(target < 0) {
            return;
        }

        // Found the combination, add the list to the result
        if(target == 0) {
            result.add(new ArrayList<>(list));
        }

        for(int i=start; i < candidates.length; i++) {
            // add the item and try combinations with that number
            list.add(candidates[i]);
            findCombinations(candidates, i, target - candidates[i], list, result);
            ////we could not find the combination , so return and last element will be removed
            list.remove(list.size()-1);
        }
    }
}
