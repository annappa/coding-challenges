package com.kscm.arrays.challenge12;

import java.util.Arrays;

public class SolutionP1 {
    public static void main(String[] args) {
        //Input: s = ["h","e","l","l","o"]
        //Output: ["o","l","l","e","h"]
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Given String is: " + Arrays.toString(s));
        reverseString(s);
        System.out.println("After reverse,  String is: " + Arrays.toString(s));
    }

    private static void reverseString(char[] s) {
        int l=0;
        int r=s.length-1;
        while(l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++;
            r--;
        }
    }
}
