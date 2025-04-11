package com.kscm.arrays.challenge7;

import java.util.Arrays;

class Solution {
    //We are applying binary search here
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;

            //Everytime, we split the array , we need to search in the sorted array
            // So by comparing the elem at mid to elem at high, we will come to know
            // whether left side is sorted or right side it sorted
            if (nums[mid] > nums[high]) {// The left side is sorted.
                if (target >= nums[low] && target < nums[mid]) { // check left side
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else { // The right side is sorted.
                if (target > nums[mid] && target <= nums[high]) { // check right side
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1}, 7)); //3
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0)); //4
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 3)); //-1
        System.out.println(solution.search(new int[]{1}, 0)); // -1
    }
}
