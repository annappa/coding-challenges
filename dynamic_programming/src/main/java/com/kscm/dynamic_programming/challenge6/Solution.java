package com.kscm.dynamic_programming.challenge6;

public class Solution {
    public int twoEggDrop(int n) {
        int m=0;
        int k=2;
        int[][] dp = new int[n+1][k+1];
        while(dp[m][k] < n) {
            ++m;
            for(int i=1; i<=k; i++) {
                dp[m][i]=dp[m-1][i-1] + dp[m-1][i] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.twoEggDrop( 2)); //2
        System.out.println(solution.twoEggDrop(2)); //2
        System.out.println(solution.twoEggDrop(6)); //3
        System.out.println(solution.twoEggDrop(14)); //4
        System.out.println(solution.twoEggDrop(100)); //14
    }
}
