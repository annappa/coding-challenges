package com.kscm.arrays.challenge11;

public class MedianOfTwoSortedArrayOfDifferentLengthP1 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

    private static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1);
        }

        double median;
        int x = arr1.length;
        int y = arr2.length;

        int low=0;
        int high=x;
        while(low <= high) {
            int partitionX = (low+high)/2;
            int partitionY = (x+y+1)/2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE: arr2[partitionY-1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE: arr2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
