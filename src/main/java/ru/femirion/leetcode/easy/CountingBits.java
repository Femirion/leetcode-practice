package ru.femirion.leetcode.easy;

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {

    /**
     * Runtime 2 ms Beats 92.21% of users with Java
     * Memory 46.43 MB Beats 72.38% of users with Java
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}
