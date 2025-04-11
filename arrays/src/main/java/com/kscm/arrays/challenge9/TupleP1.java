package com.kscm.arrays.challenge9;

public class TupleP1 implements Comparable<TupleP1> {
    int x, y, sum;

    public TupleP1(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }

    @Override
    public int compareTo(TupleP1 other) {
        return this.sum - other.sum;
    }
}
