package com.kscm.dynamic_programming.challenge5;

public class Solution2BruteForce {
    // n --> number of eggs
    // k --> number of floors
    public static int superEggDrop(int n, int k) {
        int[][] dp = new int[n+1][k+1];

        // i refers to eggs
        //j  refers to floors
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=k; j++) {
                if(i == 1) {
                    dp[i][j] = j;
                } else if(j == 1) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;

                    for(int mj=j-1, pj=0; mj>=0; mj--, pj++) {
                        int v1 = dp[i][mj]; //egg survives
                        int v2 = dp[i-1][pj];
                        int val = Math.max(v1, v2);
                        min = Math.min(val, min);
                    }

                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Solution2BruteForce solution1 = new Solution2BruteForce();
        // n --> number of eggs
        // k --> number of floors
        System.out.println(solution1.superEggDrop(1, 2)); //2
        System.out.println(solution1.superEggDrop(2, 2)); //2
        System.out.println(solution1.superEggDrop(2, 6)); //3
        System.out.println(solution1.superEggDrop(3, 14)); //4
    }
}
