package com.kscm.arrays.challenge20;

public class SolutionP1 {
    public static void main(String[] args) {
        //            0   1  2  3  4
        int[] arr = {-2, -1, 0, 4, 5};

        System.out.println(findMatch(arr));
    }

    private static int findMatch(int[] arr) {
        int l = 0;
        int r = arr.length-1;

        while(l <= r) {
            int mid = (l + r) / 2;
            if(arr[mid] == mid) {
                return mid;
            } else if(arr[mid] < mid) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return -1;
    }
}
