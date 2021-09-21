package com.kscm.coding.common.challenge2;

public class Solution2 {
    //if interviewer says, u can not use long, then go for other solution
    public int reverse(int x) {
        long answer = 0;
        while(x != 0) {
            answer = 10 * answer + x % 10;
            x /= 10;
        }
        return (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) ? 0 : (int) answer;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse( -123));
        System.out.println(solution.reverse( 0));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}