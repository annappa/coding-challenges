package com.kscm.string.challenge5;

public class MinFlipsMonotonIncreasingSolution {

    public int minFlipsMonoIncr(String s) {
        int flips = 0, number_of_ones = 0;

        for(char c : s.toCharArray()) {
            if (c == '0') {
                //If we encounter 0 and haven't enountered one yet, no need to do anything, its valid
                if(number_of_ones == 0) {
                    continue;
                } else {
                    // If we encounter 0 and have enountered one, then we have options to flip this zero to one and check with with previous one's equence
                    // Example, if string is 110, then , monotonic seq with min flips is 111 by converting last 0 to one
                    // So we increment the flips count by 1
                    flips++;
                }
            } else {
                // We are keeping track of ones count , so when we enounter zero, we will check with zeros flips count with ones count, answer will be the minimum of these
                // Example, if string is 110, then , monotonic seq with min flips is 111 by converting last 0 to one
                // So we increment the number_of_ones count by 1
                number_of_ones++;
            }
            //Minimum of ones count and number of zero flips is the answer
            flips = Math.min(flips, number_of_ones);
        }
        return flips;
    }

    public static void main(String[] args) {
        MinFlipsMonotonIncreasingSolution solution = new MinFlipsMonotonIncreasingSolution();
        System.out.println(solution.minFlipsMonoIncr("00110")); //1
        System.out.println(solution.minFlipsMonoIncr("010110")); //2
        System.out.println(solution.minFlipsMonoIncr("00011000")); //2
        System.out.println(solution.minFlipsMonoIncr("000000")); //0
        System.out.println(solution.minFlipsMonoIncr("11111")); //0
        System.out.println(solution.minFlipsMonoIncr("00110110")); //2
    }
}
