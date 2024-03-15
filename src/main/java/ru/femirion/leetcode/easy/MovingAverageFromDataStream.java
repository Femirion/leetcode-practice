package ru.femirion.leetcode.easy;

import java.util.LinkedList;

/**
 * 346. Moving Average from Data Stream
 * https://leetcode.com/problems/moving-average-from-data-stream/description/
 */
public class MovingAverageFromDataStream {

    private LinkedList<Integer> queue = new LinkedList<>();
    private int maxSize = 0;
    private int curSum = 0;

    /**
     * Runtime 43 ms Beats 56.96% of users with Java
     * Memory 49.48 MB Beats 41.94% of users with Java
     */
    public MovingAverageFromDataStream(int size) {
        maxSize = size;
    }

    public double next(int val) {
        if (queue.size() < maxSize) {
            curSum = curSum + val;
            queue.addLast(val);
            return (double) curSum / queue.size();
        }
        int first = queue.removeFirst();
        queue.addLast(val);
        curSum = curSum - first + val;
        return (double) curSum / maxSize;
    }
}
