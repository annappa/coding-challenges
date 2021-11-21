package com.kscm.challenge2;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementInArraySolution {
    // Time complexity is O(n) as inside while loop runs occassionaly
    private int[] solve(int[] arr) {
        int numberOfElements = arr.length;
        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(arr[numberOfElements-1]);
        nge[numberOfElements-1] = -1;

        for(int i=numberOfElements-2; i>=0; i--) {
            // -(pop), answer, +(add)

            // while stack is not empty and elements in stack are less than the new element, keep popping as we need the greater element
            while(stack.size() > 0 && arr[i] >= stack.peek()) {
                stack.pop();
            }

            // After popping, if stack becomes empty, means there is no greater element, so nge(next greater element) is -1
            if(stack.size() == 0) {
                nge[i] = -1;
            } else { // next greate element is the element which is on the stack
                nge[i] = stack.peek();
            }

            // add the current element , so it will be considered for the next
            stack.push(arr[i]);
        }

        return nge;
    }

    private int[] solve_2(int[] arr) {
        int numberOfElements = arr.length;
        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);

        for(int i=1; i < numberOfElements; i++) {
            // 1. Pop the lesser elements + answer, 2. add
            while(stack.size() > 0 && arr[i] > arr[stack.peek()]) {
                int pos = stack.peek();
                nge[pos] = arr[i];
                stack.pop();
            }

            //push the current element index
            stack.push(i);
        }

        while (stack.size()>0) {
            int pos = stack.peek();
            nge[pos] = -1;
            stack.pop();
        }

        return nge;
    }

    public static void main(String[] args) {
        NextGreaterElementInArraySolution solution = new NextGreaterElementInArraySolution();
        System.out.println(Arrays.toString(solution.solve(new int[]{2, 3, 5, 1, 2, 9, 8}))); //[3, 5, 9, 2, 9, -1, -1]

        System.out.println("----- Second Appraoch-----");
        System.out.println(Arrays.toString(solution.solve_2(new int[]{2, 3, 5, 1, 2, 9, 8}))); //[3, 5, 9, 2, 9, -1, -1]

    }
}
