package ru.femirion.leetcode.easy;

/**
 * 3032. Count Numbers With Unique Digits II
 * https://leetcode.com/problems/count-numbers-with-unique-digits-ii/description/
 */
public class CountNumbersWithUniqueDigitsII {

    /**
     * Runtime 3 ms Beats 93.86%
     * Memory 40.75 MB Beats 95.61%
     */
    public int numberCount(int a, int b) {
        int result = 0;
        for (int i = a; i <= b; i++) {
            if (hasUniqueDigits(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean hasUniqueDigits(int num) {
        if (num == 1000) {
            return false;
        }

        if (num < 10) {
            return true;
        }

        // 1-9
        int d1 = num % 10;
        num = num / 10;

        // 10-99
        int d2 = num % 10;
        if (d1 == d2) {
            return false;
        }
        num = num / 10;
        if (num == 0) {
            return true;
        }

        // 100-99
        int d3 = num % 10;
        if (d1 == d3 || d2 == d3) {
            return false;
        }
        num = num / 10;
        if (num == 0) {
            return true;
        }

        return true;
    }
}
