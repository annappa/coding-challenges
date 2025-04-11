package com.kscm.arrays.challenge16;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInArraySolutionP1 {
    public static void main(String[] args) {
        KthSmallestElementInArraySolutionP1 solution = new KthSmallestElementInArraySolutionP1();
        System.out.println("------ Priority Queue Approach -----");
        System.out.println(solution.findKthSmallest_using_pq(new int[]{3,2,1,5,6,4}, 2)); // [6, 5, 4, 5, 3, 2, 1] -> answer is 2
        System.out.println(solution.findKthSmallest_using_pq(new int[]{3,2,3,1,2,4,5,5,6}, 6)); //[1, 2, 2, 3, 3, 4, 5, 5, 6] -- answer is 4

        System.out.println("------ Quick Select Approach -----");
        System.out.println(solution.findKthSmallest_using_quicksort_select(new int[]{3,2,1,5,6,4}, 2)); // [6, 5, 4, 5, 3, 2, 1] -> answer is 2
        System.out.println(solution.findKthSmallest_using_quicksort_select(new int[]{3,2,3,1,2,4,5,5,6}, 6)); //[1, 2, 2, 3, 3, 4, 5, 5, 6] -- answer is 4
    }

    public int findKthSmallest_using_pq(int[] arr, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        for(int i=0; i<arr.length; i++) {
            pq.offer(arr[i]);
            if(pq.size() > k)
                pq.poll();
        }
        // [1, 2, 3, 4, 5, 6] , k =2 , -> [1, 2]
        return pq.peek();
    }

    private int findKthSmallest_using_quicksort_select(int[] arr, int k) {
        int n = arr.length;
        int left = 0;
        int right = n-1;
        k=k-1;
        while(left < right) {
            int pI = partion(arr, right, left, right);
            if(k < pI) {
                right = pI - 1;
            } else if(k > pI){
                left = pI + 1;
            } else {
                break;
            }
        }
        return arr[k];
    }

    private int partion(int[] arr, int pivot, int left, int right) {
        int pivoteValue = arr[pivot];
        int pI = left;
        for(int i=left; i<right; i++) {
            if(arr[i]<pivoteValue) {
                swap(arr, i, pI);
                pI++;
            }
        }
        swap(arr, pivot, pI);
        return pI;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
