package com.kscm.string.challenge4;

/*
The task here is to count the minimum flips required to create a beautiful sequence.

Since we need all the Heads (H) before Tails (T) to create a beautiful sequence, we can initialize the minimum and current flips to the count of "H".

Then loop through the string and for every "H", decrement your current flip by 1 else increment by 1. Also keep a track of minimum flips as the minimum of current and minimum flips.

The Time Complexity for this solution is O(n) and Space Complexity is O(1).
 */
public class FlipCoinBeautifulSequenceSolution {
    public int minFlips(String coins) {
        char headChar = 'H';
        int headCharCount = 0;

        for (int i = 0; i < coins.length(); i++) {
            if (coins.charAt(i) == headChar) {
                headCharCount++;
            }
        }

        int min_flips = headCharCount;
        int curr_flips = headCharCount;

        for(char c : coins.toCharArray()) {
            if( c == 'H') {
                curr_flips -= 1;
            } else {
                curr_flips += 1;
            }
            min_flips = Math.min(min_flips, curr_flips);
        }
        return min_flips;
    }

    // This one is similar to leetcode : 926
    public int minFlips1(String coins) {
        //HHT --> HHH
        //Counter for the number of T's
        int number_of_t = 0;
        int flips = 0;

        for(char ch : coins.toCharArray()) {
            if( ch == 'H') {
                // When we encounter H and T is not encountered yet, no need to do anything as its already in the sequence
                if(number_of_t == 0) {
                    continue;
                } else { // otheerwise, we can flip this and check
                    flips ++;
                }
            } else { // Otherwise keep track of the number of T's
                number_of_t++;
            }
            //Min of number T's and number of flips is the answer
            //HHT --> HHH , flipped T to H
            flips = Math.min(flips, number_of_t);
        }
        return flips;
    }

    public static void main(String[] args) {
        FlipCoinBeautifulSequenceSolution solution = new FlipCoinBeautifulSequenceSolution();
        System.out.println(solution.minFlips("THHHTH"));
        System.out.println(solution.minFlips("HHHHH"));
        System.out.println(solution.minFlips("HHTHH"));
        System.out.println(solution.minFlips("HHTHHTHHT"));
        System.out.println(solution.minFlips("TTTTTTT"));
        System.out.println(solution.minFlips("HHTHTT"));

        System.out.println("----------------");
        System.out.println(solution.minFlips1("THHHTH"));
        System.out.println(solution.minFlips1("HHHHH"));
        System.out.println(solution.minFlips1("HHTHH"));
        System.out.println(solution.minFlips1("HHTHHTHHT"));
        System.out.println(solution.minFlips1("TTTTTTT"));
        System.out.println(solution.minFlips1("HHTHTT"));

    }
}
