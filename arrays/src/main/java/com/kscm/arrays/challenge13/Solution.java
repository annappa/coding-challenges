package com.kscm.arrays.challenge13;

import java.util.Arrays;

public class Solution {
    //Aproach1
    public void rotate(int[] nums, int k) {
        int arraySize = nums.length;
        int[] res = new int[arraySize];
        int resI=0;
        int i=arraySize-k; // 7-3 = 4
        while(i < arraySize) {
            res[resI++] = nums[i++];
        }

        for(int j=0; j<arraySize-k; j++) {
            res[resI++] = nums[j];
        }

        System.out.println(Arrays.toString(res));
    }

    //Approach2
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //Approach3
    //O(n)
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        //(1) new array;
        int[] oldNums = nums.clone();
        for(int i = 0; i< nums.length;i++){
            nums[(i+k)%nums.length] = oldNums[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("--- Approach1 ---");
        solution.rotate(new int[]{1,2,3,4,5,6,7}, 3); // [5,6,7,1,2,3,4]
        solution.rotate(new int[]{1,2,5,6,7}, 3); // [5,6,7,1,2,3,4]

        System.out.println("--- Approach2 ---");
        solution.rotate1(new int[]{1,2,3,4,5,6,7}, 3); // [5,6,7,1,2,3,4]
        solution.rotate1(new int[]{1,2,5,6,7}, 3); // [5,6,7,1,2,3,4]

        System.out.println("--- Approach3 ---");
        solution.rotate2(new int[]{1,2,3,4,5,6,7}, 3); // [5,6,7,1,2,3,4]
        solution.rotate2(new int[]{1,2,5,6,7}, 3); // [5,6,7,1,2,3,4]
    }
}
