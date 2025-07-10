package com.kscm.coding.common.challenge6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateCharFinder {
    public static void main(String[] args) {
        DuplicateCharFinder duplicateCharFinder = new DuplicateCharFinder();
        //duplicateCharFinder.findDuplicate("India is my country");
        duplicateCharFinder.findDuplicateUsingJDK8("India is my country");
    }

    /*
        Time complexity: o(n)
        Space Complexity: o(n)
    */
    private void findDuplicate(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("Input string is empty or null.");
            return;
        }
        //should we consider case sensitiveness ?
        //str = str.toLowerCase();
        Map<Character, Integer> baseMap = new HashMap<Character, Integer>();
        char[] charArray = str.toCharArray();
        for (Character ch : charArray) {
            if(baseMap.containsKey(ch)) {
                baseMap.put(ch, baseMap.get(ch) + 1);
            } else {
                baseMap.put(ch, 1);
            }
            //baseMap.put(ch, baseMap.getOrDefault(ch, 0) + 1);
        }

        Set<Character> keys = baseMap.keySet();
        for (Character ch : keys) {
            if(baseMap.get(ch) > 1) {
                System.out.println(ch + " is " + baseMap.get(ch) + " times");
            }
        }

    }

    /*
        Time complexity: o(n)
        Space Complexity: o(n)
    */
    private void findDuplicateUsingJDK8(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("Input string is empty or null.");
            return;
        }
        long currentTimeInMillis = System.currentTimeMillis();
        Map<Character, Long> charFrequency = str.toLowerCase()
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(c -> (char) c.intValue(), Collectors.counting()));

        charFrequency.forEach((ch, freq) -> {
            if (freq > 1) {
                System.out.println(ch + " appears " + freq + " times");
            }
        });
        System.out.println("time taken: " + (System.currentTimeMillis() - currentTimeInMillis) + " ms");
    }
}

/*
Time complexity: o(n)
Space Complexity: o(n)
 */
