package ru.femirion.leetcode.easy;

/**
 * 263. Ugly Number
 * https://leetcode.com/problems/ugly-number/description/
 */
public class UglyNumber {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.68 MB Beats 64.34% of users with Java
     */
    public boolean isUgly(int n) {
        if (n == 1) {
            return false;
        }

        if (n == 0) {
            return false;
        }

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                continue;
            }
            if (n % 3 == 0) {
                n = n / 3;
                continue;
            }

            if (n % 5 == 0) {
                n = n / 5;
                continue;
            }

            return n == 1;
        }
        return true;
    }
}
