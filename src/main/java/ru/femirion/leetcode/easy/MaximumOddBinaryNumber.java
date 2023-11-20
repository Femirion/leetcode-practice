package ru.femirion.leetcode.easy;

/**
 * 2864. Maximum Odd Binary Number
 * https://leetcode.com/problems/maximum-odd-binary-number/
 */
public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder result = new StringBuilder(s);

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (count > 1) {
                result.setCharAt(i, '1');
                count--;
            } else {
                result.setCharAt(i, '0');
            }
        }

        result.setCharAt(s.length() - 1, '1');
        return result.toString();
    }
}
