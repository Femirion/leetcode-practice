package ru.femirion.leetcode.medium;

/**
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class StringToIntegerATOI {

    /**
     * Runtime 1 ms Beats 100.00%
     * Memory 42.84 MB Beats 16.19%
     */
    public int myAtoi(String s) {
        long result = 0;

        Boolean positive = null;
        boolean isNumberFound = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!isDigit(c)) {
                if (isNumberFound) {
                    break;
                }
                if (c == '-') {
                    if (positive != null) {
                        break;
                    }
                    positive = false;
                    continue;
                }
                if (c == '+') {
                    if (positive != null) {
                        break;
                    }
                    positive = true;
                    continue;
                }
                if (c != ' ') {
                    break;
                }
                if (c == ' ' && positive != null) {
                    break;
                }
                continue;
            }

            if (c == '0' && !isNumberFound) {
                isNumberFound = true;
                continue;
            }

            isNumberFound = true;
            result = result * 10 + ((int) c - '0');

            if (Integer.MAX_VALUE < result) {
                break;
            }
        }

        result = positive == null || positive == true ? result : -result;

        if (Integer.MAX_VALUE < result) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }
}
