package com.kscm.arrays.challenge16;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class Solution {

    /*
    O(N log K) running time + O(K) memory

    Other possibility is to use a max oriented priority queue that will store the K-th smallest values. The algorithm iterates over the whole input and maintains the size of priority queue.
     */
    public int findKthSmallest_using_pq(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        for(int val : nums) {
            //logk
            pq.offer(val);
            //pq.add(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    //O(n)
    public int findKthSmallest_using_quicksort_select(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }


    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && max(a[++i], a[lo]));
            while(j > lo && max(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private boolean max(int v, int w) {
        return v > w;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("------ Priority Queue Approach -----");
        System.out.println(solution.findKthSmallest_using_pq(new int[]{3,2,1,5,6,4}, 2)); // [6, 5, 4, 5, 3, 2, 1] -> answer is 2
        System.out.println(solution.findKthSmallest_using_pq(new int[]{3,2,3,1,2,4,5,5,6}, 6)); //[1, 2, 2, 3, 3, 4, 5, 5, 6] -- answer is 4

        System.out.println("------ Quick Sort Approach -----");
        System.out.println(solution.findKthSmallest_using_quicksort_select(new int[]{3,2,1,5,6,4}, 2)); // [6, 5, 4, 5, 3, 2, 1] -> answer is 2
        System.out.println(solution.findKthSmallest_using_quicksort_select(new int[]{3,2,3,1,2,4,5,5,6}, 6)); //[1, 2, 2, 3, 3, 4, 5, 5, 6] -- answer is 4
    }
}
