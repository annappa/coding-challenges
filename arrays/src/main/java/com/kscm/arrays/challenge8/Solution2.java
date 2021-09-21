package com.kscm.arrays.challenge8;

import java.util.Arrays;

public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target); //O(logn)
        result[1] = findLast(nums, target); // O(logn)
        return result;   //So O(logn) + O(logn) = 2 O(logn) = O(logn)
    }

    private int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 8))); // [3, 4]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 6))); // [-1, -1]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0))); // [-1, -1]
    }
}
