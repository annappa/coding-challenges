package com.kscm.arrays.challenge25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words =  {"bella","label","roller"};
        List<String> commonChars = solution.commonChars(words);
        System.out.println(commonChars);
    }
    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return Collections.emptyList();
        }

        int[] last = frequencyOfChars(A[0]);
        for (int i = 1; i < A.length; i++) {
            last = intersection(last, frequencyOfChars(A[i]));
        }
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }
    int[] intersection(int[] a, int[] b) {
        int[] freqArr = new int[26];
        for (int i = 0; i < 26; i++) {
            freqArr[i] = Math.min(a[i], b[i]);
        }
        return freqArr;
    }
    int[] frequencyOfChars(String str) {
        int[] freqArr = new int[26];
        for (char c : str.toCharArray())
            freqArr[c - 'a']++;
        return freqArr;
    }
}

/*
Time Complexity:
The time complexity of the provided code is O(n * m), where n is the number of strings in the input array and m is the maximum length of a string in the array. This is because we iterate over each string in the array and then iterate over each character in the string.

Space Complexity:
The space complexity of the provided code is O(m), where m is the size of the alphabet (in this case, 26). We use a fixed-size array to store the frequency of characters, so the space usage does not depend on the input size.

 */
