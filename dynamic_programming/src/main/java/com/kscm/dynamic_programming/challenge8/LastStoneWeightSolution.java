package com.kscm.dynamic_programming.challenge8;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeightSolution {
    public int lastStoneWeight(int[] stones) {
        int stonesLength = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //Creating the max heap of stones weight
        for(int stone : stones) {
            pq.offer(stone);
        }

        while(stonesLength > 1) {
            // get the first max weight stone
            int firstStone = pq.poll();
            // get the second max weight stone
            int secondStone = pq.poll();
            stonesLength -= 2;
            //Get the burst value, firstStone is always greater than secondStone
            int afterBurstValue=firstStone - secondStone;
            if(afterBurstValue > 0) {
                // After burst value needs to be added back to pq, so that it will be used in the next burst
                pq.offer(afterBurstValue);
                stonesLength += 1;
            }
        }

        // One stone left, return the wight of that
        if(!pq.isEmpty()) {
            return pq.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        LastStoneWeightSolution lastStoneWeightSolution = new LastStoneWeightSolution();
        System.out.println(lastStoneWeightSolution.lastStoneWeight(new int[]{2,7,4,1,8,1})); // 1
        System.out.println(lastStoneWeightSolution.lastStoneWeight(new int[]{1})); // 1
    }
}
