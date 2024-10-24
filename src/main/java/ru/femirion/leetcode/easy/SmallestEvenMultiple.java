package ru.femirion.leetcode.easy;

/**
 * 2413. Smallest Even Multiple
 * https://leetcode.com/problems/smallest-even-multiple/description/
 */
public class SmallestEvenMultiple {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 40.15 MB Beats 78.57%
     */
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        } else {
            return n * 2;
        }
    }
}
