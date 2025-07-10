package com.kscm.arrays.challenge3;

/*  ................  Reverse A String .................*/
// create a function that reverse a string:
// example: "Hello World" becomes "dlroW olleH"

public class ReverseString {
    // reverse method 1

    /* Inefficient approach
    Memory Consumption
    The repeated creation of temporary string objects and copying of contents leads to:

        - Increased memory allocation: Multiple string objects are created because string is immutaboe, consuming more memory.
        - Garbage collection overhead: The JVM needs to garbage collect the temporary string objects, which can lead to performance issues.

        Suppose you have a string of length n. The reverse method will create n new string objects, each with a length ranging from 1 to n.
        This results in a total memory allocation of O(n^2) characters.
     */
    private String reverse(String string) {
        String temp = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            temp += (string.charAt(i));
        }
        return temp;
    }

    //reverse method 2
    //String is immutable whereas StringBuffer and StringBuilder are mutable classes.
    //StringBuffer is thread-safe and synchronized whereas StringBuilder is not. That's why StringBuilder is faster than StringBuffer.
    private String reverse2(String string) {
        StringBuilder temp = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            temp.append(string.charAt(i));
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        // lets run our functions
        String greet = "Hello World";
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverse(greet));
        System.out.println(reverseString.reverse2(greet));
    }
}
