package com.kscm.arrays.challenge5;

import java.util.Arrays;

class Solution {
    public static int[] moveZeroes(int[] nums) {
        int k=0;
        int arrLength = nums.length;
        for(int i=0; i<arrLength; i++) {
            if(nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        while(k < arrLength) {
            nums[k] = 0;
            k++;
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] arr = moveZeroes(new int[]{1, 0, 2, 0, 3});
        System.out.println(Arrays.toString(arr));

        int[] arr2 = moveZeroes(new int[]{0, 0, 0, 0, 0});
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = moveZeroes(new int[]{-1, 2, -3, 0, 6, 0, 0, 7});
        System.out.println(Arrays.toString(arr3));
    }
}
