package com.kscm.dynamic_programming.begin2;

import java.util.HashMap;
import java.util.Map;

public class GridTraversalSolution {
    public int traverseGrid(int m, int n) {
        if(m ==0 || n == 0) {
            return 0;
        }

        if(m == 1 && n == 1) {
            return 1;
        }

        return traverseGrid(m-1, n) + traverseGrid(m, n-1);
    }

    public int traverseGrid_memoization(int m, int n, Map<String, Integer> mem) {
        String key = m + "," + n;
        if(mem.containsKey(key)) {
            return mem.get(key);
        }

        if(m ==0 || n == 0) {
            return 0;
        }

        if(m == 1 && n == 1) {
            return 1;
        }

        mem.put(key, traverseGrid(m-1, n) + traverseGrid(m, n-1));

        return mem.get(key);
    }

    private int traverseGridP1(int x, int y) {
        if(x==0 || y ==0)
            return 0;

        if(x==1 && y==1)
            return 1;

        return traverseGrid(x-1, y) + traverseGrid(x, y-1);
    }

    public static void main(String[] args) {
        GridTraversalSolution gridTraversalSolution = new GridTraversalSolution();
        System.out.println("-------- Using Recursive Approach ------------");
        System.out.println(gridTraversalSolution.traverseGrid(2, 3));
        System.out.println(gridTraversalSolution.traverseGrid(3, 3));
        System.out.println(gridTraversalSolution.traverseGrid(4, 5));
        System.out.println(gridTraversalSolution.traverseGridP1(4, 5));

        System.out.println("-------- Using Recursive + Memoization Approach ------------");
        System.out.println(gridTraversalSolution.traverseGrid_memoization(2, 3, new HashMap<String, Integer>()));
        System.out.println(gridTraversalSolution.traverseGrid_memoization(3, 3, new HashMap<String, Integer>()));
        System.out.println(gridTraversalSolution.traverseGrid_memoization(4, 5, new HashMap<String, Integer>()));
        System.out.println(gridTraversalSolution.traverseGrid_memoization(4, 5, new HashMap<String, Integer>()));
    }
}
