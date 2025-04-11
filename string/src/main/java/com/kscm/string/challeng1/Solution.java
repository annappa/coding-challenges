package com.kscm.string.challeng1;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0, i=0, j=0;
        HashSet set = new HashSet();

        while(j<s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max=Math.max(set.size(), max);
            } else {
                //since we are finding longest substring, we need to start removing char
                // from begining the moment we found the duplicate to find the
                // next longest substring
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcbcbb")); //3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(solution.lengthOfLongestSubstring("")); //0
    }
}
