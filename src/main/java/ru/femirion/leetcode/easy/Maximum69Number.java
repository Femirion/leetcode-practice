package ru.femirion.leetcode.easy;

/**
 * 1323. Maximum 69 Number
 * https://leetcode.com/problems/maximum-69-number/description/
 */
public class Maximum69Number {

    /**
     * Runtime 0ms Beats 100.00%
     * Memory 40.64 MB Beats 44.60%
     */
    public int maximum69Number (int num) {
        int result = num;

        int i = 0;
        int max = -1;

        while (0 < num) {
            int curDigit = num % 10;

            if (curDigit == 6) {
                max = i;
            }

            i++;
            num = num / 10;
        }

        if (max == -1) {
            return result;
        }

        if (max == 0) {
            return result + 3;
        }

        int tmp = ((int) Math.pow(10, max));

        return result + 3 * ((int) Math.pow(10, max));
    }
}
