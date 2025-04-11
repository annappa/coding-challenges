package com.kscm.arrays.challenge10;

public class Solution2P1 {
    public static void main(String[] args) {
        Solution2P1 solution = new Solution2P1();
        System.out.println(solution.kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8));
        System.out.println(solution.kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8));
        System.out.println(solution.kthSmallest(new int[][]{{-5}}, 1));
    }


    private int kthSmallest(int[][] matrix, int k) {
        int rS = matrix.length;
        int cS = matrix[0].length;

        int smallest = matrix[0][0];
        int largest = matrix[rS-1][cS-1];
        while(smallest < largest) {
            int midVal = smallest + (largest-smallest)/2;
            if(countOfSmallestElements(matrix, midVal) >= k) {
                largest = midVal;
            } else {
                smallest = midVal + 1;
            }
        }
        return smallest;
    }

    private int countOfSmallestElements(int[][] matrix, int midVal) {
        int count = 0;
        int rS = matrix.length;
        int cS = matrix[0].length;
        int i=0, j=cS-1;
        while(i<rS && j>=0) {
            int value = matrix[i][j];
            if(value <= midVal) {
                count += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
