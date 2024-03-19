package ru.femirion.leetcode.easy;

/**
 * 342. Power of Four
 * https://leetcode.com/problems/power-of-four/description/
 */
public class PowerOfFour {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.65 MB Beats 61.53% of users with Java
     */
    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 4 != 0) {
            return false;
        }
        while (0 < n) {
            if (n == 4) {
                return true;
            }
            n = n / 4;
            if (n % 4 != 0) {
                return false;
            }
        }
        return false;
    }
}
