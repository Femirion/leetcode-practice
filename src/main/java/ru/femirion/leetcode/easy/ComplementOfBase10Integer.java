package ru.femirion.leetcode.easy;

/**
 * 1009. Complement of Base 10 Integer
 * https://leetcode.com/problems/complement-of-base-10-integer/description/
 *
 * #BitManipulation
 */
public class ComplementOfBase10Integer {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 39.91 MB Beats 92.86% of users with Java
     */
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int compliment = 0;
        int curBit = 0;
        int curPos = 0;
        while (0 < n) {
            curBit = 1 & n;
            compliment = compliment | ((1 ^ curBit) << curPos);
            n = n >> 1;
            curPos++;
        }
        return compliment;
    }
}
