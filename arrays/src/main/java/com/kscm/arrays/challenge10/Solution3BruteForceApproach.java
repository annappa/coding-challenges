package com.kscm.arrays.challenge10;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution3BruteForceApproach {
    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8));
        System.out.println(kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8));
        System.out.println(kthSmallest(new int[][]{{-5}}, 1));
    }

    private static int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int r = matrix.length;
        int col = matrix.length;
        for(int i=0; i<r; i++) {
            for(int j=0; j<col; j++) {
                pq.offer(matrix[i][j]);
                if(pq.size() > k)
                    pq.poll();
            }
        }
        return pq.poll();
    }
}
