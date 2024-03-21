package ru.femirion.leetcode.easy;

/**
 * 2220. Minimum Bit Flips to Convert Number
 * https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
 */
public class MinimumBitFlipsToConvertNumber {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.18 MB Beats 86.01% of users with Java
     */
    public int minBitFlips(int start, int goal) {
        int result = 0;
        while(start != goal) {
            int sB = start & 1;
            int gB = goal & 1;
            if (sB != gB) {
                result++;
            }
            start = start >> 1;
            goal = goal >> 1;
        }
        return result;
    }
}
