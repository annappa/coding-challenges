package com.kscm.arrays.challenge12;

import java.util.Arrays;

class Solution {
    public void reverseString(char[] s) {
        for(int i = 0, j = s.length- 1 ; i < j ; i++,j--){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseString(new char[] {'h','e','l','l','o'});
        solution.reverseString(new char[] {'a','n','n','a','p', 'p', 'a'});
    }
}