package com.kscm.arrays.challenge15;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInArraySolution {
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

    Other possibility is to use a min oriented priority queue that will store the K-th largest values.
    The algorithm iterates over the whole input and maintains the size of priority queue.
     */
    public int findKthLargest_using_pq(int[] nums, int k) {

        // By default, order of priorty queue is min (Min Heap)
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            //logk
            pq.offer(val);
            //pq.add(val);

            //smaller elements will be popped out
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public int findKthLargest_using_quickselect(int[] nums, int k) {

       shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int partitionIndex = partition(nums, hi, lo, hi);
            if(partitionIndex < k) {
                lo = partitionIndex + 1;
            } else if (partitionIndex > k) {
                hi = partitionIndex - 1;
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
            swap(a, ind, r);
        }
    }

    private int partition(int[] array, int pivot, int left, int right){
        int pivotValue = array[pivot];
        int partitionIndex = left;

        // i is the scanner which is scanning all the elements and looking for the elements which are less than the pivot element
        // once we find the element which is lesser than the pivot, we will swap the element with previous partion index element
        for(int i = left; i < right; i++) {
            //i , the scanner found the element which is less than the pivot, so swap the element with previous partition index element and increment the partion index
            //basically we are bringing all the elements which are lesser than the privot to the left of the partion index.
            if(array[i] < pivotValue){
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        //swapp the element at partition index with pivat value because we have found the place for the pivot.
        swap(array, pivot, partitionIndex);
        return partitionIndex;
    }

    private void swap(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    public static void main(String[] args) {
        KthLargestElementInArraySolution solution = new KthLargestElementInArraySolution();
        System.out.println("------ Arrays sort(nlogn) Approach -----");
        System.out.println(solution.findKthLargest_using_arrays_sort_function(new int[]{3,2,1,5,6,4}, 2)); // [1, 2, 3, 4, 5, 6], answer is 5
        System.out.println(solution.findKthLargest_using_arrays_sort_function(new int[]{3,2,3,1,2,4,5,5,6}, 4)); //[1, 2, 2, 3, 3, 4, 5, 5, 6] , answer is 4


        System.out.println("------ Priority Queue Approach -----");
        System.out.println(solution.findKthLargest_using_pq(new int[]{3,2,1,5,6,4}, 2)); //min heap, [1, 2, 3, 4, 5, 6], answer is 5
        System.out.println(solution.findKthLargest_using_pq(new int[]{3,2,3,1,2,4,5,5,6}, 4)); //[1, 2, 2, 3, 3, 4, 5, 5, 6] , answer is 4

        System.out.println("------ Quick Sort Select Approach -----");
        System.out.println(solution.findKthLargest_using_quickselect(new int[]{3,2,1,5,6,4}, 2)); //[1, 2, 3, 4, 5, 6], answer is 5
        System.out.println(solution.findKthLargest_using_quickselect(new int[]{3,2,3,1,2,4,5,5,6}, 4)); //[1, 2, 2, 3, 3, 4, 5, 5, 6] , answer is 4
    }
}
