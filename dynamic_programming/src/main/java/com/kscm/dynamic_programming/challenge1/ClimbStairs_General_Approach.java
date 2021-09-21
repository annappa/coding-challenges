package com.kscm.dynamic_programming.challenge1;

//fibonocci way if the given steps for climbing are 1, 3
// 1, 1, 2, 3, 4, 6, 9
//ways(n) = ways(n-1) + ways(n-3)
//dp --> dynamic programming
public class ClimbStairs_General_Approach {
    public static int ClimbStairs_Generic(int n, int[] steps) { //n=3, {1, 2}
        if (n <= 0)
            return 0;
        int[] dp = new int[n + 1];  // int[2]
        dp[0] = 1; //

        //calculating the ways for each step till n steps and storing it in array, so the outer loop
        for (int i = 1; i <= n; i++) { // i=1, n=1 , true
            int ways = 0; //
            for (int j : steps) { // For each step, logic is -> ways(n) = ways(i - hopping_steps1) + ways(i - hopping_steps2) + ...... ways(i - hopping_stepsj)
                if (i - j >= 0) //
                    ways += dp[i - j];
            }
            dp[i] = ways; //dp[1, 1]
        }

        return dp[n];

    }

    public static int ClimbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int NMinus2 = 1;
        int NMinus1 = 2;
        int total = 0;

        for (int i = 3; i <= n; i++) {
            total = NMinus2 + NMinus1;
            NMinus2 = NMinus1;
            NMinus1 = total;
        }

        return total;
    }

    public static void main(String[] args) {

        int[] Ns = new int[] { 1, 2, 3, 4, 5, 10 };
        for (int n : Ns) {
            System.out.printf("We can climb %d stairs in = %d ways %n", n, ClimbStairs(n));
        }

        System.out.println("*****************************************");

        for (int n : Ns) {
            System.out.printf("We can climb %d stairs in = %d ways %n", n, ClimbStairs_Generic(n, new int[] { 1, 2 }));
        }
    }
}
