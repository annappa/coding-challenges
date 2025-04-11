package com.kscm.dynamic_programming.begin6;

import java.util.HashMap;
import java.util.Map;

public class CanConstructSolution {

    public boolean canConstruct(String target, String[] wordsBank) {
        if(target.equals("")) {
            return true;
        }

        for(String word : wordsBank) {
            //if word is not prefix of the target, we no need to traverse further.
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length(), target.length());
                // can u construct the remaining suffix with the given wordsbank
                if(canConstruct(suffix, wordsBank)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canConstruct_memoization(String target, String[] wordsBank, Map<String, Boolean> memo) {
        if(memo.containsKey(target)) {
            return memo.get(target);
        }

        if(target.equals("")) {
            return true;
        }

        for(String word : wordsBank) {
            //if word is not prefix of the target, we no need to traverse further.
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length(), target.length());
                // can u construct the remaining suffix with the given wordsbank
                if(canConstruct_memoization(suffix, wordsBank, memo)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }

        memo.put(target, false);
        return false;
    }

    private boolean canConstructP1(String target, String[] wordsBank) {
        if(target.equals("")) {
            return true;
        }

        for(String word: wordsBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length(), target.length());
                if(canConstructP1(suffix, wordsBank))
                    return true;
            }
        }
        return false;
    }

    private boolean canConstruct_memoizationP1(String target, String[] wordsBank, Map<String, Boolean> mem) {
        if(mem.containsKey(target)) {
            return mem.get(target);
        }

        if(target.equals(""))
            return true;

        for(String word : wordsBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length(), target.length());
                if(canConstruct_memoizationP1(suffix, wordsBank, mem)) {
                    mem.put(target, true);
                    return true;
                }
            }
        }
        mem.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        CanConstructSolution canConstructSolution = new CanConstructSolution();
        System.out.println("---------- Using Recursive Brute Force approach---------");
        System.out.println(canConstructSolution.canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstructSolution.canConstructP1("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(canConstructSolution.canConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false

        System.out.println("---------- Using Recursive Memoization---------");
        System.out.println(canConstructSolution.canConstruct_memoization("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<String, Boolean>())); // true
        System.out.println(canConstructSolution.canConstruct_memoizationP1("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<String, Boolean>())); // true
        System.out.println(canConstructSolution.canConstruct_memoization("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<String, Boolean>())); // false
    }
}
