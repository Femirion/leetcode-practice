package ru.femirion.leetcode.easy;

/**
 * 190. Reverse Bits
 * https://leetcode.com/problems/reverse-bits/description/
 *
 * #BitManipulation
 */
public class ReverseBits {

    /**
     * Runtime 0  ms Beats 100.00% of users with Java
     * Memory 41.60 MB Beats 57.87% of users with Java
     */
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = ans << 1;
            ans = ans | (n & 1);
            n = n >> 1;
        }
        return ans;
    }
}
