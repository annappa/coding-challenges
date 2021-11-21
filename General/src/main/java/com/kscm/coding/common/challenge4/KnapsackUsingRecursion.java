package com.kscm.coding.common.challenge4;

/*
Find max profit by picking items so that
    1. item can only be picked 0 or 1 time
    2. we can't exceed bag limit
 */
public class KnapsackUsingRecursion {
    //Time: 2^n
    public int knapsack(int[] wt, int profit[], int bagCapacity, int currentItemNumber) {
        if(bagCapacity == 0 || currentItemNumber == 0) {
            return 0;
        }

        if(wt[currentItemNumber-1] > bagCapacity) {
            return knapsack(wt, profit, bagCapacity, currentItemNumber-1);
        } else {
            return Math.max(knapsack(wt, profit, bagCapacity, currentItemNumber-1),
                            profit[currentItemNumber-1] + knapsack(wt, profit, bagCapacity - wt[currentItemNumber-1], currentItemNumber-1));
        }
    }


    public int knapsack_memoization(int[] wt, int profit[], int bagCapacity, int currentItemNumber, int[][] mem) {
        if(bagCapacity == 0 || currentItemNumber == 0) {
            return 0;
        }

        if(mem[bagCapacity-1][currentItemNumber-1] > 0) {
            return mem[bagCapacity-1][currentItemNumber-1];
        }

        int result;
        if(wt[currentItemNumber-1] > bagCapacity) {
            return result = knapsack(wt, profit, bagCapacity, currentItemNumber-1);
        } else {
            return mem[bagCapacity-1][currentItemNumber-1] = result = Math.max(knapsack(wt, profit, bagCapacity, currentItemNumber-1),
                    profit[currentItemNumber-1] + knapsack(wt, profit, bagCapacity - wt[currentItemNumber-1], currentItemNumber-1));
        }
    }

    public int knapsack_tabulation_dp(int[] wt, int profit[], int bagCapacity, int currentItemNumber) {
       int[][] dp = new int[currentItemNumber+1][bagCapacity+1];

       for(int i=0; i <= currentItemNumber; i++) {
           for(int j=0; j <= bagCapacity; j++) {
               if(i==0 || j==0) {
                   dp[i][j] = 0;
               } else if(wt[i-1] > j) {
                   dp[i][j] = dp[i-1][j];
               } else {
                   //int num = dp[i-1];
                   dp[i][j] = Math.max(dp[i-1][j], profit[i-1] + dp[i-1][j-wt[i-1]]);
               }
           }
       }
       return dp[currentItemNumber][bagCapacity];
    }

    public static void main(String[] args) {
        KnapsackUsingRecursion knapsackUsingRecursion = new KnapsackUsingRecursion();

        System.out.println(knapsackUsingRecursion.knapsack(new int[]{3, 2, 4}, new int[]{6, 8, 7}, 8, 3));
        System.out.println(knapsackUsingRecursion.knapsack(new int[]{1, 4, 3}, new int[]{2, 4, 4}, 5, 3));
        System.out.println(knapsackUsingRecursion.knapsack_tabulation_dp(new int[]{1, 2, 3}, new int[]{2, 3, 5}, 4, 3));


        // Using memoization
        System.out.println("-----Using memoization-----");
        int[][] mem = new int[8][3];
        System.out.println(knapsackUsingRecursion.knapsack_memoization(new int[]{3, 2, 4}, new int[]{6, 8, 7}, 8, 3, mem));
        mem = new int[5][3];
        System.out.println(knapsackUsingRecursion.knapsack_memoization(new int[]{1, 4, 3}, new int[]{2, 4, 4}, 5, 3, mem));
        System.out.println(knapsackUsingRecursion.knapsack_tabulation_dp(new int[]{1, 2, 3}, new int[]{2, 3, 5}, 4, 3));

        // Using memoization
        System.out.println("-----Using Tabulation DB-----");
        System.out.println(knapsackUsingRecursion.knapsack_tabulation_dp(new int[]{3, 2, 4}, new int[]{6, 8, 7}, 8, 3));
        mem = new int[5][3];
        System.out.println(knapsackUsingRecursion.knapsack_tabulation_dp(new int[]{1, 4, 3}, new int[]{2, 4, 4}, 5, 3));
        System.out.println(knapsackUsingRecursion.knapsack_tabulation_dp(new int[]{1, 2, 3}, new int[]{2, 3, 5}, 4, 3));
    }
}
