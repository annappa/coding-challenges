package com.kscm.arrays.challenge18;

import java.util.ArrayList;
import java.util.List;

public class SolutionP2 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(findCombinationsForTarget(candidates, target));
    }

    public static List<List<Integer>> findCombinationsForTarget(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void findCombinations(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> result) {
        if( target < 0 )
            return;

        if(target == 0)
            result.add(new ArrayList<>(list));

        for(int i=start; i<candidates.length; i++) {
            list.add(candidates[i]);
            findCombinations(candidates, i, target - candidates[i], list, result);
            list.remove(list.size() - 1 );
        }
    }
}
