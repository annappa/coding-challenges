package com.kscm.arrays.challenge15;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Solution {
    /*
    The simplest approach is to sort the entire input array and then access the element by it's index (which is O(1)) operation:

   O(N log N) running time + O(1) memory
     */
    public int findKthLargest_using_arrays_sort_function(int[] nums, int k) {
        final int N = nums.length;
        shuffle(nums);
        Arrays.sort(nums);
        return nums[N - k];
    }

    /*
    O(N log K) running time + O(K) memory

    Other possibility is to use a min oriented priority queue that will store the K-th largest values. The algorithm iterates over the whole input and maintains the size of priority queue.
     */
    public int findKthLargest_using_pq(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
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

    public int findKthLargest_using_quickselect(int[] nums, int k) {

       // shuffle(nums);
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

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("------ Arrays sort(nlogn) Approach -----");
        System.out.println(solution.findKthLargest_using_arrays_sort_function(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(solution.findKthLargest_using_arrays_sort_function(new int[]{3,2,3,1,2,4,5,5,6}, 4));


        System.out.println("------ Priority Queue Approach -----");
        System.out.println(solution.findKthLargest_using_pq(new int[]{3,2,1,5,6,4}, 2)); //
        System.out.println(solution.findKthLargest_using_pq(new int[]{3,2,3,1,2,4,5,5,6}, 4));

        System.out.println("------ Quick Sort Select Approach -----");
        System.out.println(solution.findKthLargest_using_quickselect(new int[]{3,2,1,5,6,4}, 2)); //
        System.out.println(solution.findKthLargest_using_quickselect(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
