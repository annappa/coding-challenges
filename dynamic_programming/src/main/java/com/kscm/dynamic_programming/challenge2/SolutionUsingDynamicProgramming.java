package com.kscm.dynamic_programming.challenge2;

public class SolutionUsingDynamicProgramming {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0 ) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<dp.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        SolutionUsingDynamicProgramming solution = new SolutionUsingDynamicProgramming();
        System.out.println(solution.rob(new int[]{1,2,3,1}));
        System.out.println(solution.rob(new int[]{2,7,9,3,1}));
        System.out.println(solution.rob(new int[]{7,8,12,3,4,2,6}));
        System.out.println(solution.rob(new int[]{2,1,1,2}));
    }
}
