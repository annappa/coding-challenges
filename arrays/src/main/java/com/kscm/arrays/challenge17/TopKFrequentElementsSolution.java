package com.kscm.arrays.challenge17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class TopKFrequentElementsSolution {
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    public static void main(String[] args) {
        TopKFrequentElementsSolution solution = new TopKFrequentElementsSolution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2))); //[1,2]
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,1,1,1,2,2,2,2,3,3,3}, 2))); //[1,2]
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1))); //[1]
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{-1, -1}, 1))); //[1]
    }
}
