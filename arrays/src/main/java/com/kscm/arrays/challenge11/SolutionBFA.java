package com.kscm.arrays.challenge11;

public class SolutionBFA {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] res = new int[m + n];
        int i=0, j=0, k=0;

        while(i<m && j<n) {
            if(nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while(i < m) {
            res[k++] = nums1[i++];
        }

        while(j < n) {
            res[k++] = nums2[j++];
        }

        if((res.length % 2) == 0) { // [1, 2, 3, 4] --> 4%2 = 0
            int med = res.length/2;
            double med1 = res[med-1];
            double med2 = res[med];
            return (med1+med2)/2;
        } else {
            return res[res.length/2];
        }
    }

    public static void main(String[] args) {
        SolutionBFA solutionBFA = new SolutionBFA();
        System.out.println(solutionBFA.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(solutionBFA.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(solutionBFA.findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
        System.out.println(solutionBFA.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(solutionBFA.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }
}

// [1, 3] [2] --> i=0, j=0, num1[i] <= num2[j] --> i++ -> [1], i=1, j=0
//
// num1[i] <= num2[i], i=1, j=0  ---> j++  --> [1, 2]