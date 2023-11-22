package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805. Number of Different Integers in a String
 * https://leetcode.com/problems/number-of-different-integers-in-a-string/
 */
public class NumberOfDifferentIntegersInAString {

    /**
     * Runtime 2ms Beats 98.37% of users with Java
     * Memory 40.84MB Beats 66.40% of users with Java
     */
    public int numDifferentIntegers(String word) {
        if (word.isBlank()) {
            return 0;
        }
        Set<String> numbers = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (current > '9' || current < '0') {
                if (sb.length() == 0) {
                    continue;
                }
                numbers.add(trimLeadZero(sb.toString()));
                sb = new StringBuilder();
            } else {
                sb.append(current);
            }
        }
        if (sb.length() != 0) {
            numbers.add(trimLeadZero(sb.toString()));
        }
        return numbers.size();
    }

    private String trimLeadZero(String str) {
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current != '0') {
                return str.substring(i);
            }
        }
        return "0";
    }
}
