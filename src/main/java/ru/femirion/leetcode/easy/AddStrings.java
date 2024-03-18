package ru.femirion.leetcode.easy;

/**
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/description/
 */
public class AddStrings {

    /**
     * Runtime 4 ms Beats 39.90% of users with Java
     * Memory 43.52 MB Beats 33.78% of users with Java
     */
    public String addStrings(String num1, String num2) {
        int p = num1.length() - 1;
        int q = num2.length() - 1;

        StringBuilder result = new StringBuilder();
        int transfer = 0;
        while (0 <= p || 0 <= q) {
            char pC = 0 <= p ? num1.charAt(p) : '0';
            char qC = 0 <= q ? num2.charAt(q) : '0';

            int sum = toDigit(pC) + toDigit(qC) + transfer;
            if (10 <= sum) {
                sum = sum % 10;
                transfer = 1;
            } else {
                transfer = 0;
            }
            result.insert(0, sum);
        }

        if (transfer == 1) {
            result.insert(0, 1);
        }

        return result.toString();
    }

    private int toDigit(char c) {
        return c - '0';
    }
}
