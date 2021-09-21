package com.kscm.dynamic_programming.challenge3;

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while( n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }

    public int countNumbersWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10, base = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
            base = base * (9 - i + 2);
            ans += base;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countNumbersWithUniqueDigits(2)); //91
        System.out.println(solution.countNumbersWithUniqueDigits(0));

        System.out.println("------Another Solution--------");
        System.out.println(solution.countNumbersWithUniqueDigits2(2)); //91
        System.out.println(solution.countNumbersWithUniqueDigits2(0));
    }
}
