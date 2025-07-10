package com.kscm.arrays.challenge3;

public class Practice1 {
    public static void main(String[] args) {
        //System.out.println(reverse("Hello World"));
        System.out.println(reverse2("Hello World"));
    }


    private static String reverse(String inputString) {
        String reversedString = "";
        for(int i = inputString.length() -1; i >= 0; i--) {
            reversedString += inputString.charAt(i);
        }
        return reversedString;
    }

    private static String reverse2(String inputString) {
        StringBuilder reversedString = new StringBuilder();
        for(int i = inputString.length() -1; i >= 0; i--) {
            reversedString.append(inputString.charAt(i));
        }
        return reversedString.toString();
    }
}
