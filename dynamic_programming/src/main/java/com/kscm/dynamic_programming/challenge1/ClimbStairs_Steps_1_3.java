package com.kscm.dynamic_programming.challenge1;

//fibonocci way if the given steps for climbing are 1, 3
// 1, 1, 2, 3, 4, 6, 9
//ways(n) = ways(n-1) + ways(n-3)
//dp --> dynamic programming
public class ClimbStairs_Steps_1_3 {
    public int climbStairs(int n) {
        int[] dpArr = new int[n+1];

        if(n == 1 || n == 2) {
            return 1;
        }

        if(n == 3) {
            return 2;
        }

        dpArr[0] = 1;
        dpArr[1] = 1;
        dpArr[2] = 2;

        for(int i=3; i<n; i++) {
            dpArr[i] = dpArr[i-1] + dpArr[i-3];
        }

        return dpArr[n-1];
    }

    public static void main(String[] args) {
        ClimbStairs_Steps_1_3 climbStairs = new ClimbStairs_Steps_1_3();
        System.out.println("1st Step -->" + climbStairs.climbStairs(1));
        System.out.println("2nd Step -->" + climbStairs.climbStairs(2));
        System.out.println("3rd Step -->" + climbStairs.climbStairs(3));
        System.out.println("4th Step -->" + climbStairs.climbStairs(4));
        System.out.println("5th Step -->" + climbStairs.climbStairs(5));
        System.out.println("6th Step -->" + climbStairs.climbStairs(6));
        System.out.println("7th Step -->" + climbStairs.climbStairs(7));
        System.out.println("8th Step -->" + climbStairs.climbStairs(8));
    }
}
