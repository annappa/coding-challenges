package com.kscm.arrays.challenge15;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArraySolutionP1 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargestElementInArray(arr, k));
    }

    private static int findKthLargestElementInArray(int[] arr, int k) {
        // [1 2 3 4 5 6]
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            pq.offer(arr[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
