package com.kscm.arrays.challenge11;

public class SolutionBFA2 {
    public static void main(String[] args) {
        SolutionBFA2 solutionBFA = new SolutionBFA2();
        System.out.println(solutionBFA.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(solutionBFA.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(solutionBFA.findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
        System.out.println(solutionBFA.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(solutionBFA.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n= nums2.length;
        // Current index of input array ar1[]
        int i = 0;

        // Current index of input array ar2[]
        int j = 0;
        int count;
        double m1 = -1, m2 = -1;

        // Since there are (n+m) elements,
        // There are following two cases
        // if n+m is odd then the middle
        //index is median i.e. (m+n)/2
        if ((m + n) % 2 == 1)
        {
            for(count = 0;
                count <= (n + m) / 2;
                count++)
            {
                if (i != m && j != n)
                {
                    m1 = (nums1[i] > nums2[j]) ?
                            nums2[j++] : nums1[i++];
                }
                else if (i < m)
                {
                    m1 = nums1[i++];
                }

                // for case when j<n,
                else
                {
                    m1 = nums2[j++];
                }
            }
            return m1;
        }

        // median will be average of elements
        // at index ((m+n)/2 - 1) and (m+n)/2
        // in the array obtained after merging
        // ar1 and ar2
        else
        {
            for(count = 0;
                count <= (n + m) / 2;
                count++)
            {
                m2 = m1;
                if (i != m && j != n)
                {
                    m1 = (nums1[i] > nums2[j]) ?
                            nums2[j++] : nums1[i++];
                }
                else if (i < m)
                {
                    m1 = nums1[i++];
                }

                // for case when j<m,
                else
                {
                    m1 = nums2[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }
}

// [1, 3] [2] --> i=0, j=0, num1[i] <= num2[j] --> i++ -> [1], i=1, j=0
//
// num1[i] <= num2[i], i=1, j=0  ---> j++  --> [1, 2]