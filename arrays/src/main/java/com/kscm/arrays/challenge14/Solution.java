package com.kscm.arrays.challenge14;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        printMatrix(matrix);
    }

    private void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println("Matrix elements are: ");
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int m,n;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter matrix row count: ");
        m=sc.nextInt();

        System.out.print("Enter matrix column count: ");
        n=sc.nextInt();

        System.out.println("Testing String read ....Enter name: ");
        String name = sc.next();
        System.out.println("Name is: " + name);

        //creates an array in the memory of length 10
        int[][] matrix = new int[m][n];
        System.out.println("Enter the elements of the 2D array: ");
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                //reading array elements from the user
                matrix[i][j] = sc.nextInt();
            }

        }

        Solution solution = new Solution();
        solution.printMatrix(matrix);
        solution.setZeroes(matrix);*/

        int[][] matrix1 = new int[][]{{1,1,1},{1,0,1}, {1,1,1}};
        solution.printMatrix(matrix1);
        solution.setZeroes(matrix1);

        int[][] matrix2 = new int[][]{{0,1,2,0},{3,4,5,2}, {1,3,1,5}};
        solution.printMatrix(matrix2);
        solution.setZeroes(matrix2);
    }
}

