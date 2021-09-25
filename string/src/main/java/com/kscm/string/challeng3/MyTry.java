package com.kscm.string.challeng3;

import java.util.Collections;

public class MyTry {
    public String alphabetBoardPath(String target) {
        int x=0, y=0;
        StringBuilder sb = new StringBuilder();
        for(char ch: target.toCharArray()) {
            int x1= (ch - 'a')%5;
            int y1= (ch - 'a')/5;
            sb.append(String.join("", Collections.nCopies(Math.max(0, y - y1), "U")) +
                    String.join("", Collections.nCopies(Math.max(0, x1 - x), "R")) +
                    String.join("", Collections.nCopies(Math.max(0, x - x1), "L")) +
                    String.join("", Collections.nCopies(Math.max(0, y1 - y), "D")) +
                    "!"
            );
            x=x1;
            y=y1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyTry myTry = new MyTry();
        System.out.println(myTry.alphabetBoardPath("leet")); //"DDR!UURRR!!DDD!"
    }
}

/*
a   b   c   d   e
f   g   h   i   j
k   l   m   n   o
p   q   r   s   t
u   v   w   x   y
z
 */

