package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 2160. Minimum Sum of Four Digit Number After Splitting Digits
 * https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/description/
 */
public class MinimumSumOfFourDigitNumberAfterSplittingDigits {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 40.88 MB Beats 6.97%
     */
    public int minimumSum(int num) {
        int[] digits = new int[4];

        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num = num / 10;
        }

        Arrays.sort(digits);

        return digits[0] * 10 + digits[3] + digits[1] * 10 + digits[2];
    }
}
