package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 * https://leetcode.com/problems/logger-rate-limiter/description/
 */
public class LoggerRateLimiter {

    private Map<String, Integer> map = new HashMap<>();

    /**
     * Runtime 32 ms Beats 54.22% of users with Java
     * Memory 55.06 MB Beats 82.39% of users with Java
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer loggedTimestamp = map.get(message);
        if (loggedTimestamp == null) {
            map.put(message, timestamp);
            return true;
        } else {
            if (timestamp - loggedTimestamp >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}
