package com.kscm.arrays.challenge8;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int low=0, high=nums.length;
        int mid;

        // since we are finding the range, there should be multiple values,
        // so lo < hi when compared to bs's lo <= high, in bs only one key will be there
        // So no need to search at lo = hi
        while(low<high) {
            mid = (low + high)/2;
            if(nums[mid] == target) {
                if(nums[mid-1] == nums[mid]) {
                    int i=mid-1;
                    while(i >= low && nums[i] == target) {
                        i--;
                    }
                    res[0]=i+1;
                } else {
                    res[0]=mid;
                }

                if(nums[mid+1] == nums[mid]) {
                    int i=mid+1;
                    while(i <= high && nums[i] == target) {
                        i++;
                    }
                    res[1]=i-1;
                } else {
                    res[1]=mid;
                }
            }

            if(target < nums[mid]) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
    return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 8))); // [3, 4]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 5))); // [3, 4]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 6))); // [-1, -1]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0))); // [-1, -1]
    }
}