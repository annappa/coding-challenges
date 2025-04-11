package com.kscm.arrays.challenge22;

/*
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //This is kind of like -> [1, 2, ..., n] -> sorted array , since this is sorted , we can use binary search
        // left is initialised to first version , because versions array will be like [1, 2, ..., n]
        int left = 1;
        int right = n;

        while(left < right) {
            int mid = left + (right - left) / 2; // (right - left) is for preventing overflow of large value
            // isBadVersion is the API given to check whether the version is bad or not
            // if the mid is not a bad version then it should be on the right only
            if(!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // here left should pointing at the first bad version
        return left;
    }
}
*/
