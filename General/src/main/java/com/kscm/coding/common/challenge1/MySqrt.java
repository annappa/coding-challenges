package com.kscm.coding.common.challenge1;

public class MySqrt {
    // y^2 = x
    private static int calculateSqrt(int x) {
        int left = 1;
        int right = x;

        if(x < 2) {
            return x;
        }

        while(left < right) { // 1 < 8
            int mid = (left + right) / 2; // mid=4, mid=2
            int temp = x / mid; // 8/4=2, 8/2=4  // doing this division instead of multiplication --> mid*mid=x
            if(temp == mid) { // 2 == 4,
                return mid;
            } else if(temp < mid){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        System.out.println(calculateSqrt(4));
        System.out.println(calculateSqrt(8));
    }
}

// Sqrt(8)
// 1, 2, 3, 4, 5, 6, 7, 8
// l=1, r=8 ..
// mid=1+8/2=4
//temp=8/4=2

//l=1, r=4
//1,2,3,4
//mid=1+4/2=2
//temp=8/2=4

// 4<2?
// l=2+1=3
// r=4
// 3,4
// mid=3+4/2=7/2=3
//temp=8/3=2
// 2<3?

//l=3, right=3
//answer: 3-1=2