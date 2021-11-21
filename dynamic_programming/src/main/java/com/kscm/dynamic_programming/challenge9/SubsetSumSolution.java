package com.kscm.dynamic_programming.challenge9;

public class SubsetSumSolution {
    public boolean isSumFound(int[] nums, int sum, int n) {
        boolean dp[][] = new boolean[n+1][sum+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(i==0 || j == 0) {
                    dp[i][j] = false;
                } else if(nums[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                } else if(nums[i-1] == j) {
                    dp[i][j] = true;
                } else {
                    //exclude , include
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        SubsetSumSolution subsetSumSolution = new SubsetSumSolution();
        System.out.println(subsetSumSolution.isSumFound(new int[]{2, 2, 3}, 5, 3));
        System.out.println(subsetSumSolution.isSumFound(new int[]{2, 2, 3}, 22, 3));
        System.out.println(subsetSumSolution.isSumFound(new int[]{2, 2, 3}, 7, 3));
    }
}
