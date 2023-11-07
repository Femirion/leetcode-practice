package ru.femirion.leetcode.easy;

/**
 * 2437. Number of Valid Clock Times
 * https://leetcode.com/problems/number-of-valid-clock-times/
 */
public class NumberOfValidClockTimes {

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 39.92MB Beats 87.40% of users with Java
     */
    public int countTime(String time) {
        char first = time.charAt(0);
        char second = time.charAt(1);
        int result = 1;
        if (first == '?') {
            if (second == '?') {
                result = 24;
            } else if (second < '4') {
                result = 3;
            } else {
                result = 2;
            }
        } else {
            if (second == '?') {
                if (first == '2') {
                    result = 4;
                } else {
                    result = 10;
                }
            }
        }

        char current = time.charAt(3);
        if (current == '?') {
            result = result * 6;
        }
        current = time.charAt(4);
        if (current == '?') {
            result = result * 10;
        }
        return result;
    }

}
