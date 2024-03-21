package ru.femirion.leetcode.medium;

/**
 * 1318. Minimum Flips to Make a OR b Equal to c
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
 *
 * #BitManipulation
 */
public class MinimumFlipsToMakeAORBEqualToC {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.69 MB Beats 15.79% of users with Java
     */
    public int minFlips(int a, int b, int c) {
        int count = 0;

        while (0 < a || 0 < b || 0 < c) {
            int aB = a & 1;
            int bB = b & 1;
            int cB = c & 1;

            if (aB == 1 && bB == 1 && cB == 0) {
                count = count + 2;
            } else if ((aB | bB) != cB) {
                count++;
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return count;
    }
}
