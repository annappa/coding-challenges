package com.kscm.challenge5;

import java.util.Stack;

public class FindImbalanceInAmazonInventory {

    public int findImbalance(int[] weight) {
        int sumMax = sumSubarrayMax(weight);
        int sumMn = sumSubarrayMins(weight);
        System.out.println("Max:" + sumMax + ", Min:" + sumMn);
        return sumMax - sumMn;
    }

    //[3, 2, 3]
    public int sumSubarrayMins(int[] arr) {
        long res = 0, mod = (int)1e9 + 7;
        int n = arr.length, left[] = new int[n], right[] = new int[n];
        Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();

        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > arr[i])
                count += s1.pop()[1];
            s1.push(new int[] {arr[i], count});
            left[i] = count;
        }
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= arr[i])
                count += s2.pop()[1];
            s2.push(new int[] {arr[i], count});
            right[i] = count;
        }
        for (int i = 0; i < n; ++i)
            res = (res + (long)arr[i] * left[i] * right[i]) % mod;
        return (int)res;
    }

    //[3, 2, 3]
    public int sumSubarrayMax(int[] arr) {
        long res = 0, mod = (int)1e9 + 7;
        int n = arr.length, left[] = new int[n], right[] = new int[n];
        Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();

        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] < arr[i])
                count += s1.pop()[1];
            s1.push(new int[] {arr[i], count});
            left[i] = count;
        }
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] <= arr[i])
                count += s2.pop()[1];
            s2.push(new int[] {arr[i], count});
            right[i] = count;
        }
        for (int i = 0; i < n; ++i)
            res = (res + (long)arr[i] * left[i] * right[i]) % mod;
        return (int)res;
    }

    public static void main(String[] args) {
        FindImbalanceInAmazonInventory solution = new FindImbalanceInAmazonInventory();
        System.out.println(solution.findImbalance(new int[]{3, 2, 3})); //3 --> [3], [3, 2], [3, 2, 3], [2, 3] --> 12 - 9 = 3
        System.out.println(solution.findImbalance(new int[]{1, 3, 2})); // 5 --> [1], [1, 3], [1, 3, 2], [3, 2], [3], [2]  --> 15 - 10 --> 5
        System.out.println(solution.findImbalance(new int[]{4, 4, 4, 4, 4})); // 0
        System.out.println(solution.findImbalance(new int[]{4, 4, 4, 4, 4})); // 0
        System.out.println(solution.findImbalance(new int[]{3, 3, 2, 3})); // 0 --> [3], [3], [2], [3], [3, 3], [3, 3, 2], [3, 3, 2, 3], [3, 2], [3, 2, 3], [2, 3] --> 29 - 24 = 5
    }
}
