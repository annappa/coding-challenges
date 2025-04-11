package com.kscm.arrays.challenge9;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionP1 {
    public static void main(String[] args) {
        int[] num1 = {1, 7, 11};
        int[] num2 = {2, 4, 6};
        int k =3;

        // (1,2), (1,4), (1, 6)

        System.out.println(findKPairsWithSmallestSum(num1, num2, k));

        int[] num3 = {1, 1, 2};
        int[] num4 = {1, 2, 3};
        k=2;
        System.out.println(findKPairsWithSmallestSum(num3, num4, k));

        int[] num5 = {1, 2};
        int[] num6 = {3};
        k=3;
        System.out.println(findKPairsWithSmallestSum(num5, num6, k));
    }

    private static List<List<Integer>> findKPairsWithSmallestSum(int[] num1, int[] num2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if(num1 == null || num1.length == 0 || num2.length == 0 || k == 0)
            return res;

        int m=num1.length;
        int n=num2.length;
        Queue<TupleP1> pq = new PriorityQueue<>();

        //pairs from first element of num1 to num2 elements will be smaller, so add all these elements to pq
        for(int j=0; j<num2.length; j++) {
            pq.offer(new TupleP1(0, j, num1[0] + num2[j]));
        }

        for(int i=0; i<Math.min(k, m*n);i++) {
            TupleP1 t1 = pq.poll();

            List<Integer> list = new ArrayList<>();
            list.add(num1[t1.x]);
            list.add(num2[t1.y]);
            res.add(list);

            // we reached the last row, so no more elements can be added, so skipping
            if(t1.x == m-1)
                continue;

            pq.offer(new TupleP1(t1.x + 1, t1.y, num1[t1.x+1]+num2[t1.y]));
        }
        return res;
    }
}
