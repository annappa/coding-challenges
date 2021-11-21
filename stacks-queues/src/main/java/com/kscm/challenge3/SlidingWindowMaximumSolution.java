package com.kscm.challenge3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class SlidingWindowMaximumSolution {
    public int[] maxSlidingWindow_using_stack(int[] nums, int k) {
        int numOfElements=nums.length;
        int[] nge = new int[numOfElements];
        int[] swm = new int[numOfElements - k + 1];
        Stack<Integer> st = new Stack<Integer>();

        st.push(numOfElements-1);
        nge[numOfElements-1]=numOfElements;

        for(int i = numOfElements - 2; i>=0; i--) {
            //-a+
            while (st.size()>0 && nums[i] > nums[st.peek()]) {
                st.pop();
            }

            if(st.size() == 0) {
                nge[i] = nums.length;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }


        for(int i=0; i <= numOfElements - k; i++) {
            //enter the loop to find the maximum of window starting at i
            int j=i;

            while(nge[j] < i + k) {
                j = nge[j];
            }

            swm[i]=nums[j];
        }

        return swm;
    }

    public int[] maxSlidingWindow_using_dqueue(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] res = new int[n-k+1];
        int ri = 0;
        int left=0, right=0; // left and right represents our window (0 to k-1)

        // store index
        Deque<Integer> q = new ArrayDeque<>();

        while (right < n) {
            //pop smaller values from queue, so only bigger values gets added
            while (!q.isEmpty() && a[q.peekLast()] < a[right]) {
                q.pollLast();
            }

            q.offer(right);

            // remove left value if its out of our window
            if(left > q.peek()) {
                q.poll();
            }

            //range is finished now, add the result
            if(right+1 >= k) {
                res[ri++] = a[q.peek()];
                left +=1;
            }

            right +=1;
        }

        return res;
    }

    public int[] maxSlidingWindow_using_max_heap(int[] nums, int k) {
        // assume nums is not null
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1]; // number of windows

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> (o2 - o1)); // stores values

        for (int i = 0; i < n; ++i) {
            int start = i - k;

            if (start >= 0) {
                maxPQ.remove(nums[start]); // remove the out-of-bound value
            }

            maxPQ.offer(nums[i]);

            if (maxPQ.size() == k) {
                result[i - k + 1] = maxPQ.peek();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximumSolution solution = new SlidingWindowMaximumSolution();

        System.out.println("---- First Approach Using Double ended queue-----");
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_dqueue(new int[]{2, 3, 5, 1, 2, 9, 8}, 3))); //[3,3,5,5,6,7]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_dqueue(new int[]{1,3,-1,-3,5,3,6,7}, 3))); //[3,3,5,5,6,7]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_dqueue(new int[]{1}, 1))); //[1]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_dqueue(new int[]{1,-1}, 1))); //[1, -1]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_dqueue(new int[]{9,11}, 2))); //[11]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_dqueue(new int[]{4,-2}, 2))); //[4]

        System.out.println("---- Second Approach Using Max Heap priority Queue-----");
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_max_heap(new int[]{2, 3, 5, 1, 2, 9, 8}, 3))); //[3,3,5,5,6,7]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_max_heap(new int[]{1,3,-1,-3,5,3,6,7}, 3))); //[3,3,5,5,6,7]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_max_heap(new int[]{1}, 1))); //[1]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_max_heap(new int[]{1,-1}, 1))); //[1, -1]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_max_heap(new int[]{9,11}, 2))); //[11]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_max_heap(new int[]{4,-2}, 2))); //[4]

        System.out.println("---- third Approach Using Stack----");
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_stack(new int[]{2, 3, 5, 1, 2, 9, 8}, 3))); //[3,3,5,5,6,7]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_stack(new int[]{1,3,-1,-3,5,3,6,7}, 3))); //[3,3,5,5,6,7]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_stack(new int[]{1}, 1))); //[1]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_stack(new int[]{1,-1}, 1))); //[1, -1]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_stack(new int[]{9,11}, 2))); //[11]
        System.out.println(Arrays.toString(solution.maxSlidingWindow_using_stack(new int[]{4,-2}, 2))); //[4]
    }
}
