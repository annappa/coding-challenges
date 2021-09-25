package com.kscm.dynamic_programming.challenge7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int i=0; i<stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        //from first stone, we can take only one jump
        map.get(stones[0]).add(1);

        for(int i=0; i< stones.length; i++) {
            int currStone = stones[i];
            HashSet<Integer> jumps = map.get(currStone);

            for(int jump : jumps ) {
                int position = currStone + jump;

                //frag has reached the last stone
                if(position == stones[stones.length - 1])
                        return  true;

                //if stone is available
                if(map.containsKey(position) == true) {
                    // since from the current position, frog can jump by using jump-1 , jump or jump+1
                    if(jump-1 > 0)
                        map.get(position).add(jump-1);
                    map.get(position).add(jump);
                    map.get(position).add(jump+1);

                }
            }

        }
        return false;
    }

    public boolean canCross2(int[] stones) {
        for(int i = 3; i < stones.length; i++) {
            if(stones[i] > stones[i - 1] * 2) {
                return false;
            }
        }

        Set<Integer> stoneSet = new HashSet<>();
        Set<List<Integer>> visited = new HashSet<>();
        for(int stone: stones) {
            stoneSet.add(stone);
        }

        int lastPosition = stones[stones.length - 1];
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        positions.add(0);
        jumps.add(0);

        while(!positions.isEmpty()) {
            int pos = positions.pop();
            int dis = jumps.pop();

            for(int i = dis - 1; i <= dis + 1; i++) {
                if(i <= 0) {
                    continue;
                }

                int nextPos = pos + i;
                if(nextPos == lastPosition) {
                    return true;
                }

                List<Integer> target = new ArrayList<>();
                target.add(nextPos);
                target.add(i);

                if(stoneSet.contains(nextPos) && !visited.contains(target)) {
                    positions.add(nextPos);
                    jumps.add(i);
                    visited.add(target);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(solution.canCross(new int[]{0,1,2,3,4,8,9,11}));

        System.out.println("----Another Approach-----");
        System.out.println(solution.canCross2(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(solution.canCross2(new int[]{0,1,2,3,4,8,9,11}));
    }
}
