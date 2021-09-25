package com.kscm.coding.common.challenge3;

import java.util.HashSet;

public class Solution {
    public String nextClosestTime(String time) {
        //Convert the given time to total minutes
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
        minutes += Integer.parseInt(time.substring(3));

        HashSet<Integer> digits = new HashSet<Integer>();
        for(char digit: time.toCharArray()) {
            digits.add(digit - '0');
        }

        while(true) {
            // Increment the minutes by 1 minutes
            // Also, at 23:59, times resets to 00:00, to handle that use % of 24*60
            minutes = (minutes + 1) % (24*60);

            //take each digits of nexttime hh:mm
            int[] nextTime = new int[]{ minutes / 60 /10,  minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10};

            boolean isValid = true;
            for(int digit: nextTime) {
                if(!digits.contains(digit))
                    isValid = false;
            }

            if (isValid) {
                return String.format("%02d:%02d", minutes/60, minutes%60);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nextClosestTime("19:34")); // 19:39
        System.out.println(solution.nextClosestTime("23:59")); // 22:22

    }
}
