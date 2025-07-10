package com.kscm.arrays.challenge6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice1 {
    public static void main(String[] args) {
        Practice1 practice1 = new Practice1();
        System.out.println(Arrays.toString(practice1.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(practice1.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(practice1.twoSum(new int[]{3,3}, 6)));
        System.out.println(Arrays.toString(practice1.twoSum(new int[]{1,3}, 6)));

    }

    private static int[] twoSum(int[] nums, int target) {
        int[] pos = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for(int i =0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                pos[0] = map.get(target - nums[i]);
                pos[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return pos;
    }
}
