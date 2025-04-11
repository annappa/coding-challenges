package com.kscm.string.challeng2;

import java.util.HashSet;
import java.util.Set;

/*
Greedy works since we can only delete characters.

So, count each character first. For each 26 characters, check if it's count is already used. If so, delete characters until you find unused count, or reach zero.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDeletions("aab")); //0
        System.out.println(solution.minDeletions("aaabbbcc")); // 2
        System.out.println(solution.minDeletions("ceabaacb")); //2
    }

    public int minDeletions(String s) {
        int[] freq = new int[26];
        Set<Integer> used = new HashSet<>();
        int res=0;
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;  // ASCII of 'a' is 97, z is 122 (97 + 25)
        }

        for (int i = 0; i < 26; ++i) {
            while (freq[i] > 0 && !used.add(freq[i])) {
                --freq[i];
                ++res;
            }
        }
        return res;
    }

    public int minDeletions2(String s) {

    }
}
