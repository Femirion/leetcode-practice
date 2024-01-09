package ru.femirion.leetcode.easy;

/**
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 40.22MB Beats 21.03% of users with Java
     */
    public boolean isPerfectSquare(int num) {
        long low = 1;
        long high = num;
        long mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

}
