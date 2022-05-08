package com.kscm.arrays.challenge20;

public class Solution {
    public static void main(String[] args) {
        //List<Integer> list = new ArrayList<>(Arrays.asList(-2, -1, 1, 3, 5));
                    // 0   1  2  3  4
        int[] arr1 = {-2, -1, 1, 3, 5};
        System.out.println(find(arr1));

        int[] arr2 = {-2, -1, 2, 4, 5};
        System.out.println(find(arr2));
    }

    public static int find(int[] arr) {
        int left = 0;   //0
        int right = arr.length-1; //4

        while( left <= right ) {
            int mid = (left + right) / 2;

            if(arr[mid] == mid) {
                return mid;
            } else if(arr[mid] < mid) {
                left = mid+1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
