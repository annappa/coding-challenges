package com.kscm.arrays.challenge11;

public class  SolutionBruteForceApproachP1 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

    private static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        double median;
        int lA1 = arr1.length;
        int lA2 = arr2.length;

        int[] resArr = new int[lA1 + lA2];

        int i=0, j=0, k=0;

        while(i < lA1 && j < lA2) {
            if(arr1[i] <= arr2[j] ) {
                resArr[k++] = arr1[i++];
            } else {
                resArr[k++] = arr2[j++];
            }
        }

        while(i < lA1) {
            resArr[k++] = arr1[i++];
        }

        while(j < lA2) {
            resArr[k++] = arr2[j++];
        }

        int mid = resArr.length / 2;
        if( (resArr.length % 2) == 0) {
            double med1 = resArr[mid];
            double med2 = resArr[mid-1];
            median = ( med1 + med2)/2;
        } else {
            median = resArr[mid];
        }
        return median;
    }
}
