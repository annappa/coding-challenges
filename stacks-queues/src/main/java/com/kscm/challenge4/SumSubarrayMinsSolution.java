package com.kscm.challenge4;
import java.util.*;


public class SumSubarrayMinsSolution {
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

    public int sumSubarrayMax(int[] arr) {
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

    public static void main(String[] args) {
        SumSubarrayMinsSolution solution = new SumSubarrayMinsSolution();
        System.out.println(solution.sumSubarrayMins(new int[]{3,1,2,4})); // sum is 7
        System.out.println(solution.sumSubarrayMins(new int[]{11,81,94,43,3})); // sum is 444
    }
}
