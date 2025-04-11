package com.kscm.arrays.challenge17;

import java.util.*;

public class TopKFrequentElementsSolutionP2 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(findTopKFrequentElements(arr, k)));
    }

    public static int[] findTopKFrequentElements(int[] arr, int k) {
        int[] top = new int[k];

        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0)+1);
        }

        Queue<Integer> pq = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2)
        );

        for(int n : count.keySet()) {
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }

        for(int j=k-1; j>=0; j--) {
            top[j] = pq.poll();
        }

        return top;
    }

}
