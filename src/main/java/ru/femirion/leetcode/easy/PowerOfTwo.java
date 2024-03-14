package ru.femirion.leetcode.easy;

/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/description/
 */
public class PowerOfTwo {

    /**
     * Runtime 1 ms Beats 44.92% of users with Java
     * Memory 41.13 MB Beats 12.05% of users with Java
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        n = Math.abs(n);
        while (n > 0) {
            if (n % 2 != 0) {
                return false;
            }

            if (n == 2) {
                return true;
            }
            if (n == 1) {
                return false;
            }
            n = n >>> 1;
        }
        return false;
    }
}
