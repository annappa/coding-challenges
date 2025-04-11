package com.kscm.arrays.challenge8;

import java.util.Arrays;

public class SolutionP1 {
    public static void main(String[] args) {
        SolutionP1 solution = new SolutionP1();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 8))); // [3, 4]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 6))); // [-1, -1]
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0))); // [-1, -1]
    }

    private int[] searchRange(int[] arr, int elem) {
        int[] res = new int[]{-1, -1};

        if(arr.length == 0) {
            return res;
        }

        int low=0;
        int hi = arr.length;

        while(low < hi) {
            int mid = (low + hi)/2;

            if(arr[mid] == elem) {
                if(arr[mid-1] == elem) {
                    int i = mid-1;
                    while(i>=low && arr[i] == elem) {
                        i--;
                    }
                    res[0] = i+1;
                } else {
                    res[0] = mid;
                }

                if(arr[mid+1] == elem) {
                    int j=mid+1;
                    while(j < hi && arr[j] == elem) {
                        j++;
                    }
                    res[1] = j-1;
                } else {
                    res[1] = mid;
                }
            }

            if(elem < arr[mid]) {
                hi = mid-1;
            } else {
                low = mid+1;
            }
        }
        return res;
    }
}
