package ru.femirion.leetcode.easy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 2259. Remove Digit From Number to Maximize Result
 * https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
 */
public class RemoveDigitFromNumberToMaximizeResult {

    /**
     * Runtime 10ms Beats 8.07% of users with Java
     * Memory 43.70MB Beats 5.88% of users with Java
     */
    public String removeDigit(String number, char digit) {
        List<BigInteger> numbers = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            if (current == digit) {
                numbers.add(new BigInteger(number.substring(0, i) + number.substring(i + 1)));
            }
        }
        BigInteger max = BigInteger.ZERO;
        for (BigInteger current : numbers) {
            if (max.compareTo(current) < 0) {
                max = current;
            }
        }
        return max.toString();
    }
}
