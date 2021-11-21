package com.kscm.dynamic_programming.begin1;

import java.util.HashMap;
import java.util.Map;

//0, 1, 1, 2, 3, 5, 8, 13, 21 .....
public class FindFibRecursivelySolution {
    //Time complexity : O(2^n)
    //Space complexty: O(n)
    public int findFib(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        return findFib(n-1) + findFib(n-2);
    }

    //Time complexity : O(n)
    //Space complexty: O(n)
    public int findFib_memoization(int n, Map<Integer, Integer> mem) {
        //Base condition
        //If our map contains fib of the number, then return that value since its already calculated and stored.
        if(mem.containsKey(n)) {
            return mem.get(n);
        }
        //Base condition
        //First element in fib series is zero
        if(n == 1) {
            return 0;
        }
        //Base condition
        //Second element in fib series is 1
        if(n == 2) {
            return 1;
        }
        //Store the value of the calculated fib number
        mem.put(n, findFib_memoization(n-1, mem) + findFib_memoization(n-2, mem));
        return mem.get(n);
    }

    public static void main(String[] args) {
        FindFibRecursivelySolution findFibRecursivelySolution = new FindFibRecursivelySolution();
        System.out.println("-------- Using Recursive Approach ------------");
        System.out.println(findFibRecursivelySolution.findFib(4)); // Answer: 2
        System.out.println(findFibRecursivelySolution.findFib(7)); // Answer: 8
        System.out.println(findFibRecursivelySolution.findFib(8)); // Answer: 8
        // For below input, code runs for very long time as time complexity of this algo is : O(2^n).
        //System.out.println(findFibRecursivelySolution.findFib(50));

        System.out.println("-------- Using Recursive+Memoization Approach ------------");
        System.out.println(findFibRecursivelySolution.findFib_memoization(4, new HashMap<Integer, Integer>())); // Answer: 2
        System.out.println(findFibRecursivelySolution.findFib_memoization(7, new HashMap<Integer, Integer>())); // Answer: 8
        System.out.println(findFibRecursivelySolution.findFib_memoization(8, new HashMap<Integer, Integer>())); // Answer: 8
        // For below input, code runs faster now as time complexity of this algo is : O(n).
        System.out.println(findFibRecursivelySolution.findFib_memoization(50, new HashMap<Integer, Integer>())); // Answer: 8
    }
}
