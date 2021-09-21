package com.kscm.coding.common.challenge2;

class Solution {
    public int reverse(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) // to check overflowing.. if overflowing happens, this will not match with the already computed result
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse( -123));
        System.out.println(solution.reverse( 0));
    }
}
