package com.kscm.coding.common.challenge5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution1P1RateLimiter {
    private Map<String, HitCounter> map = new HashMap<>();
    private static final int API_RATE_LIMITS = 3;
    private static final long API_RATE_LIMIT_TIME = 1000L;

    class HitCounter {
        private Queue<Long> queue;

        public HitCounter() {
            queue = new LinkedList<>();
        }

        boolean hit(long timestamp) {
            while(!queue.isEmpty() && timestamp-queue.peek() >= API_RATE_LIMIT_TIME)
                queue.poll();

            if(queue.size() < API_RATE_LIMITS) {
                queue.offer(timestamp);
                return true;
            }
            return false;
        }

    }

    public boolean isAllow(String customerId) {
        HitCounter hc = map.get(customerId);

        long currentTimeInMillis = System.currentTimeMillis();

        if(hc == null) {
            hc = new HitCounter();
            map.put(customerId, hc);
        }

        return hc.hit(currentTimeInMillis);
    }
}
