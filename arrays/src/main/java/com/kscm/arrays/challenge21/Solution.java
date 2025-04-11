package com.kscm.arrays.challenge21;

public class Solution {
    public static void main(String[] args) {
        //if you look from top - right corner, it looks like a BST(Binary search tree)
        int[][] matrix = new int[][]{
                {1,  4,  7,  11, 15},
                {2,  5,  8,  12, 19},
                {3,  6,  9,  16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target = 31;
        printMatrix(matrix);
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rS=matrix.length;
        int cS=matrix[0].length;
        int i=0, j=cS-1;

        while(i<rS && j>=0) {
            int num = matrix[i][j];
            if(num == target) {
                return true;
            } else if(num > target) {
                j--;
            } else {
                i++;
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
