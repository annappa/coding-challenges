package com.kscm.coding.common.challenge5;

public class Solution1P1 {
    public static void main(String[] args) {
        Solution1P1RateLimiter limiter = new Solution1P1RateLimiter();
        System.out.println("test1 " + limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("Sleeping for 1 second");
        try {
            java.lang.Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("test1 " + limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test1 " +limiter.isAllow("test1"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test2 " +limiter.isAllow("test2"));
        System.out.println("test1 " +limiter.isAllow("test1"));
    }
}
