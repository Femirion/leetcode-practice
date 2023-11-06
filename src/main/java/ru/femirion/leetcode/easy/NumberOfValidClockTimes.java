package ru.femirion.leetcode.easy;

/**
 * 2437. Number of Valid Clock Times
 *
 * https://leetcode.com/problems/number-of-valid-clock-times/
 *
 You are given a string of length 5 called time, representing the current time on a digital clock in the format "hh:mm". The earliest possible time is "00:00" and the latest possible time is "23:59".

 In the string time, the digits represented by the ? symbol are unknown, and must be replaced with a digit from 0 to 9.

 Return an integer answer, the number of valid clock times that can be created by replacing every ? with a digit from 0 to 9.

 Constraints:

 time is a valid string of length 5 in the format "hh:mm".
 "00" <= hh <= "23"
 "00" <= mm <= "59"
 Some of the digits might be replaced with '?' and need to be replaced with digits from 0 to 9.
 *
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
