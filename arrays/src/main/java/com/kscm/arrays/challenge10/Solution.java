package com.kscm.arrays.challenge10;

import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();

        //first row elements are already in sorted (asc) order, so add all these to pq
        for(int j = 0; j <= n-1; j++)
            pq.offer(new Tuple(0, j, matrix[0][j]));

        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();

            // we reached the last row, so no more elements can be added, so skipping
            if(t.x == n-1)
                continue;
            // add the next row elements
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8));
        System.out.println(solution.kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8));
        System.out.println(solution.kthSmallest(new int[][]{{-5}}, 1));
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}
