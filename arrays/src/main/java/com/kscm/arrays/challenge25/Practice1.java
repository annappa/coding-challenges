package com.kscm.arrays.challenge25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice1 {
    public static void main(String[] args) {
        String[] words = {"bella", "label", "roller"};
        Practice1 practice1 = new Practice1();
        List<String> commonChars = practice1.findCommonCharacters(words);
        System.out.println(commonChars);
    }

    private List<String> findCommonCharacters(String[] words) {
        if(words == null || words.length == 0) {
            return Collections.emptyList();
        }
        int[] last = frequencyOfChars(words[0]);
        for(int i = 1; i < words.length; i++) {
            last = compareAndCombineCharsFrequency(last, frequencyOfChars((words[i])));
        }
        List<String> commonCharsList = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            if(last[i] != 0) {
                char a = 'a';
                a += i;
                String commonChar = String.valueOf(a);
                while(last[i] > 0) {
                    commonCharsList.add(commonChar);
                    last[i]--;
                }
            }
        }
        return commonCharsList;
    }

    private int[] compareAndCombineCharsFrequency(int[] last, int[] current) {
        int[] result = new int[26];
        for(int i = 0; i < 26; i++) {
            result[i] = Math.min(last[i], current[i]);
        }
        return result;
    }

    private int[] frequencyOfChars(String word) {
        int[] frequencyOfChars = new int[26];
        for(char ch : word.toCharArray()) {
            frequencyOfChars[ch - 'a']++;
        }
        return frequencyOfChars;
    }
}
