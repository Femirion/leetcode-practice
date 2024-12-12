package ru.femirion.leetcode.easy;

import java.util.PriorityQueue;

/**
 * 2558. Take Gifts From the Richest Pile
 * https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/
 */
public class TakeGiftsFromTheRichestPile {

    /**
     * Runtime 4 ms Beats 99.23%
     * Memory 42.39 MB Beats 66.23%
     */
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        long count = 0;
        for (int g : gifts) {
            queue.offer(g);
            count = count + g;
        }

        for (int i = 0; i < k; i++) {
            if (queue.isEmpty()) {
                return count;
            }

            int g = queue.poll();
            if (0 == g) {
                return count;
            }

            int squareRoot = (int) Math.sqrt(g);
            queue.offer(squareRoot);

            count = count - g + squareRoot;

        }
        return count;
    }
}
