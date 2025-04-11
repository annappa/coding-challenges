package com.kscm.arrays.challenge14;

import java.util.HashSet;
import java.util.Set;

public class SolutionP1 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        printMatrix(matrix);
        fillZeros(matrix);
        printMatrix(matrix);
    }

    private static void fillZeros(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> rowSet = new HashSet<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("Matrix is");
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
