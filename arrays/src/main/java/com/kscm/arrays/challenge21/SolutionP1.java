package com.kscm.arrays.challenge21;

public class SolutionP1 {
    public static void main(String[] args) {
        //if you look from top - right corner, it looks like a BST(Binary search tree)
        int[][] matrix = new int[][] {
                {1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target = 30;
        printMatrix(matrix);
        System.out.println(searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int rS = matrix.length;
        int cS = matrix[0].length;
        int i=0;
        int j=cS-1;
        while(i<rS && j>=0) {
            int value = matrix[i][j];
            if(target < value) {
                j--;
            } else if(target > value) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    private static void printMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
