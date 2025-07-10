package com.kscm.arrays.challenge1;

import java.util.HashSet;

public class Practice1 {
    private static char[] array1 = {'a', 'b', 'c'};
    private static char[] array2 = {'d', 'e', 'f'};
    public static void main(String[] args) {
        System.out.println(containsCommonItemBFS(array1, array2));
        //System.out.println(containsCommonItem(array1, array2));
    }

    private static boolean containsCommonItem(char[] array1, char[] array2) {
        HashSet<Character> commonItemSet = new HashSet<>();
        for (char c: array1) {
            commonItemSet.add(c);
        }

        for(char c: array2) {
            if(commonItemSet.contains(c))
                return true;
        }
        return false;
    }

    private static boolean containsCommonItemBFS(char[] array1, char[] array2) {
        for(char c: array1) {
            for(char c1: array2) {
                if(c == c1) {
                    return true;
                }
            }
        }
        return false;
    }
}
