package com.kscm.arrays.challenge14;

import java.util.HashSet;
import java.util.Set;

public class SolutionP2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        printMatrix(matrix);
        setZeros(matrix);
        printMatrix(matrix);

        int[][] matrix2 = new int[][]{{0, 1, 2, 0},{3, 4, 5, 2},{1, 3, 1, 5}};
        printMatrix(matrix2);
        setZeros(matrix2);
        printMatrix(matrix2);
    }

    private static void setZeros(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rSet = new HashSet<>();
        Set<Integer> cSet = new HashSet<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    rSet.add(i);
                    cSet.add(j);
                }
            }
        }

        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if(rSet.contains(i) || cSet.contains(j))
                    matrix[i][j] = 0;
            }
        }

    }

    private static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println("Matrix is...");
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
