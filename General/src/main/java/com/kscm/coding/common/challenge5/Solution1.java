package com.kscm.coding.common.challenge5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution1 {
    static class RateLimiter {
        class HitCounter {
            Queue<Long> q = null;

            public HitCounter() {
                q = new LinkedList<Long>();
            }

            public boolean hit(long timestamp) {
                //if there is any api call which was made 1 sec before of this api call, remove it
                while(!q.isEmpty() && timestamp-q.peek() >= TIME_LIMIT)
                    q.poll();

                if(q.size() < REQUEST_LIMIT)
                {
                    q.offer(timestamp);
                    return true;
                }

                return false;
            }
        }

        private final int REQUEST_LIMIT = 3;
        private final long TIME_LIMIT = 1000L;

        private final Map<String, HitCounter> clientHitMap = new HashMap<String, HitCounter>();

        public boolean isAllow(String client_id) {
            HitCounter h = clientHitMap.get(client_id);

            long curTime = System.currentTimeMillis();

            if(h == null) {
                h = new HitCounter();
                clientHitMap.put(client_id, h);
            }

            return h.hit(curTime);
        }
    }

    public static void main(String[] args) {
        RateLimiter limiter = new RateLimiter();
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
