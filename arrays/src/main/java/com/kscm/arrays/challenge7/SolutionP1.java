package com.kscm.arrays.challenge7;

public class SolutionP1 {
    public static void main(String[] args) {
        SolutionP1 solution = new SolutionP1();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0)); //4
    }

    private int search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(arr[mid] == target) {
                return mid;
            }

            if(arr[mid] > arr[hi]) { // left sorted
                // should be in left side of the array as per below condition
                if(target >= arr[lo] && target < arr[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // right sorted
                if(target <= arr[hi] && target > arr[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
