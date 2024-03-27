package ru.femirion.leetcode.easy;

/**
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/description/
 *
 * #Bit
 */
public class NumberOf1Bits {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.80 MB Beats 17.88% of users with Java
     */
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.94 MB Beats 11.15% of users with Java
     */
    public int hammingWeight1(int n) {
        int bitCount = 0;
        while(0 < n) {
            if ((n & 1) == 1) {
                bitCount++;
            }
            n = n >> 1;
        }
        return bitCount;
    }
}
