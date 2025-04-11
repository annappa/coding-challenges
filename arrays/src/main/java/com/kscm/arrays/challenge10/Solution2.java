package com.kscm.arrays.challenge10;

class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8));
        System.out.println(solution.kthSmallest(new int[][]{{1,5,9}, {10,11,13}, {12,13,15}}, 8));
        System.out.println(solution.kthSmallest(new int[][]{{-5}}, 1));
    }

    public int kthSmallest(int[][] matrix, int k) {
        //top left is the smallest value, bottom right is the largest value in this matrix
        // To understand the below logic, check the challenge22 package problem
        int smallest = matrix[0][0];
        int largest = matrix[matrix.length-1][matrix[0].length-1];
        while (smallest < largest) {
            int medVal = smallest + (largest - smallest) / 2;
            if (getNumberOfElementsSmallerThenMedVal(matrix, medVal) >= k) {  //not return even count == k, since medVal might not exist in this matrix.
                largest = medVal;
            } else {  //count < k
                smallest = medVal + 1;
            }
        }
        return smallest;
    }

    //https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66160/AC-clean-Java-solution
    //Look at challenge21 package problem
    private int getNumberOfElementsSmallerThenMedVal(int[][] matrix, int target) {
        int count = 0;
        int i = 0;
        int j = matrix.length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] <= target) {
                count = count + j + 1;  //all the elements on the left hand side in this row are <= target
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
