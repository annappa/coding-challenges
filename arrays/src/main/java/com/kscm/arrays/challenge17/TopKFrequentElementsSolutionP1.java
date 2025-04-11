package com.kscm.arrays.challenge17;

import java.util.*;

public class TopKFrequentElementsSolutionP1 {

    public static int[] findTopKFrequentElements(int[] arr, int k) {
        //[1, 1, 1, 2, 2, 3]
        int[] top = new int[k];

        //if there is only one element in the array, then we no need to take any action
        if(k == arr.length) {
            return arr;
        }

        //We need to create a map of element and its frequency
        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                //Comparator implementation, less frequent element first
                (n1, n2) -> count.get(n1) - count.get(n2)
        );

        for(int n : count.keySet()) {
            pq.add(n);
            if( pq.size() > k)
                pq.poll();
        }

        for(int j=k-1; j>=0; j--) {
            top[j] = pq.poll();
        }

        return top;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(findTopKFrequentElements(arr, k)));
    }
}
