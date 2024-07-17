package ru.femirion.leetcode.medium;

import java.util.LinkedList;

/**
 * 362. Design Hit Counter
 * https://leetcode.com/problems/design-hit-counter/description/
 */
public class DesignHitCounter {

    private LinkedList<Integer> queue = new LinkedList<>();

    public void hit(int timestamp) {
        queue.addLast(timestamp);
    }

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.32 MB Beats 53.90%
     */
    public int getHits(int timestamp) {
        if (queue.isEmpty()) {
            return 0;
        }
        while(!queue.isEmpty() && 300 <= timestamp - queue.getFirst()) {
            queue.removeFirst();
        }
        return queue.size();
    }
}
