package ru.femirion.leetcode.easy;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 2278. Percentage of Letter in String
 * https://leetcode.com/problems/percentage-of-letter-in-string/
 */
public class PercentageOfLetterInString {

    /**
     * Runtime 1ms Beats 15.80% of users with Java
     * Memory 39.79MB Beats 98.65% of users with Java
     */
    public int percentageLetter(String s, char letter) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == letter) {
                result++;
            }
        }

        return new BigDecimal(result)
                .divide(new BigDecimal(s.length()), new MathContext(2, RoundingMode.DOWN))
                .multiply(new BigDecimal(100)).intValue();
    }

}
