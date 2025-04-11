package com.kscm.arrays.challenge23;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] time = new int[]{30,20,150,100,40};
        int[] time2 = new int[]{60,60,60};
        int[] time3 = new int[]{60};
        int[] time4 = new int[]{60, 20};
        System.out.println(numPairsDivisibleBy60(time));
        System.out.println(numPairsDivisibleBy60(time2));
        System.out.println(numPairsDivisibleBy60(time3));
        System.out.println(numPairsDivisibleBy60(time4));


        System.out.println(numPairsDivisibleBy60Practice1(time));
        System.out.println(numPairsDivisibleBy60Practice1(time2));
        System.out.println(numPairsDivisibleBy60Practice1(time3));
        System.out.println(numPairsDivisibleBy60Practice1(time4));
    }

    // Time complexity: O(n)
    // Space complexity: O(
    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int cntr = 0;
        for (int t : time) { // O(n)
            // t % 60 + (60 - (t%60)) = 60.
            // ex1: t=20 , (20%60) + (60 - (20%60)) = 20 + (60-20) = 20 + 40 = 60
            // ex2: t=120, (120%60) + (60 - (120%60)) = 0 + (60 - 0) = 60

            //Checking if we have already found the next value whose value is as the above formula - (60 - (t%60))
            // last %60 is for the values which are multiples of 60, means remainder will be 0.
            // We have to do counter increment logic first becuase we have to see if have the next value already in the map
            cntr += map.getOrDefault((60 - t % 60) % 60, 0); // O(1)
            //cntr += map.getOrDefault(60 - t % 60, 0); // O(1)
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return cntr;
    }

    public static int numPairsDivisibleBy60Practice1(int[] time) {
        int cnt=0;
        Map<Integer, Integer> remainderMap = new HashMap<>();

        //{30,20,150,100,40}
        for(int t : time) {
            int nextValue = (60 - (t % 60)) % 60;
            cnt = cnt + remainderMap.getOrDefault(nextValue, 0);
            remainderMap.put(t%60, remainderMap.getOrDefault(t%60, 0) + 1);
        }
        return cnt;
    }

    public static int numPairsDivisibleBy60Practice2(int[] time) {
        int cntr = 0;
        Map<Integer, Integer> remMap = new HashMap<>();

        for(int t : time) {
            int remTime = (60 - t % 60) % 60;
            cntr += remMap.getOrDefault(remTime, 0);
            remMap.put(t%60 , remMap.getOrDefault(t%60, 0) + 1);
        }

        return cntr;
    }
}
