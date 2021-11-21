package com.kscm.arrays.challenge9;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0)
            return res;

        //Add all the pairs of 1st element from 1st array to the all the elements of sec array because they are of minimum sum as both arrays are sorted in ascendind order
        for(int j = 0; j <= n-1; j++)
            pq.offer(new Tuple(0, j, nums1[0]+nums2[j]));

        for(int i = 0; i < Math.min(k, m *n); i++) {
            Tuple t = pq.poll();

            List<Integer> list = new ArrayList<Integer>();
            list.add(nums1[t.x]);
            list.add(nums2[t.y]);
            res.add(list);

            if(t.x == m - 1)
                continue;

            pq.offer(new Tuple (t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
        System.out.println(solution.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2));
        System.out.println(solution.kSmallestPairs(new int[]{1,2}, new int[]{3}, 3));
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
