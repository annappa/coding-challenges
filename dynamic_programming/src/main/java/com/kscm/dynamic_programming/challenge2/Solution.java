package com.kscm.dynamic_programming.challenge2;

public class Solution {
   /* public int rob(int[] num) {
        int path1 = 0;
        int path2 = 0;
        for (int n : num) {
            int temp = path1;
            path1 = Math.max(path1, path2);
            path2 = n + temp;
        }
        return Math.max(path1, path2);
    }*/

    public int rob(int[] nums)
    {
        int ifRobbedPrevious = 0; 	// max monney can get if rob current house
        int ifDidntRobPrevious = 0; // max money can get if not rob current house

        // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
        for(int i=0; i < nums.length; i++)
        {
            // If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
            int currRobbed = ifDidntRobPrevious + nums[i];

            // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
            int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);

            // Update values for the next round
            ifDidntRobPrevious  = currNotRobbed;
            ifRobbedPrevious = currRobbed;
        }

        return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}));
        System.out.println(solution.rob(new int[]{2,7,9,3,1}));
        System.out.println(solution.rob(new int[]{7,8,12,3,4,2,6}));
        System.out.println(solution.rob(new int[]{2,1,1,2}));
    }
}
