package com.kscm.arrays.challenge6;

import java.util.Arrays;

public class Practice1BFS {
    public static void main(String[] args) {
        Practice1BFS p1 = new Practice1BFS();
        System.out.println(Arrays.toString(p1.twoSumByBruteForce(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(p1.twoSumByBruteForce(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(p1.twoSumByBruteForce(new int[]{3,3}, 6)));
        System.out.println(Arrays.toString(p1.twoSumByBruteForce(new int[]{1,3}, 6)));
    }

    private static int[] twoSumByBruteForce(int[] nums, int target) {
        int[] pos = {-1, -1};
        for( int i=0; i < nums.length; i++) {
            for(int j=0; j < nums.length; j++) {
                if(i == j) {
                    continue;
                }
                if(nums[i] + nums[j] == target) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }
}
