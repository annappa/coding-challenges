package com.kscm.arrays.challenge6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    //Time complexity : O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); //O(1)

        for(int i=0; i<nums.length; i++) { //O(n)
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3,3}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{1,3}, 6)));
    }
}



