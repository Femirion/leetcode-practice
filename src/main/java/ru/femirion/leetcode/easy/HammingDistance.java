package ru.femirion.leetcode.easy;

/**
 * 461. Hamming Distance
 * https://leetcode.com/problems/hamming-distance/description/
 *
 * #BitManipulation
 */
public class HammingDistance {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.12 MB Beats 78.69% of users with Java
     */
    public int hammingDistance(int x, int y) {
        int result = 0;

        while (0 < x || 0 < y) {
            if ((x & 1) != (y & 1)) {
                result++;
            }
            x = x >> 1;
            y = y >> 1;
        }

        return result;
    }
}
