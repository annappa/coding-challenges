package com.kscm.dynamic_programming.challenge1;

//fibonocci way if the given steps for climbing are 1, 2
public class ClimbStairs_Steps_1_2 {
    public int climbStairs(int n) {
        if( n <= 0 || n == 1 || n == 2) {
            return n;
        }

        int all_ways=0;
        int one_step_before=2;
        int two_steps_before=1;

        for(int i=3; i<=n; i++) {
            all_ways = one_step_before + two_steps_before; // 3
            two_steps_before = one_step_before; // 1, 2, 3 -->
            one_step_before = all_ways;
        }

        return all_ways;
    }

    public static void main(String[] args) {
        ClimbStairs_Steps_1_2 climbStairs = new ClimbStairs_Steps_1_2();
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
