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

    /**
     * Runtime 0ms Beats 100.00%of users with Java
     * Memory 40.40MB Beats 16.32%of users with Java
     */
    public boolean isPerfectSquare2(int num) {
        if (num == 1) {
            return true;
        }
        long start = 1;
        long end = num;
        long current = num / 2;
        long result;

        while (start <= end) {
            result = current * current;
            if (result == num) {
                return true;
            }
            if (result > num) {
                end = current;
            } else {
                start = current;
            }
            current = start + ((end - start) / 2);
            if (end - start == 1) {
                return false;
            }
        }

        return false;
    }

}
