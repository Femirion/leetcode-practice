package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 2336. Smallest Number in Infinite Set
 * https://leetcode.com/problems/smallest-number-in-infinite-set/description/
 */
public class SmallestNumberInInfiniteSet {

    /**
     * Runtime 21 ms Beats 38.60% of users with Java
     * Memory 45.64 MB Beats 22.34% of users with Java
     */
    private PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
    private BitSet set = new BitSet(1002);

    public SmallestNumberInInfiniteSet() {
        for (int i = 1; i <= 1000; i++) {
            queue.add(i);
        }
        set.set(0, 1001);
    }

    public int popSmallest() {
        int min = queue.poll();
        set.clear(min);
        return min;
    }

    public void addBack(int num) {
        if (set.get(num)) {
            return;
        }
        set.set(num);
        queue.add(num);
    }
}
