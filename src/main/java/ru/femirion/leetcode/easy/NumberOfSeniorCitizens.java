package ru.femirion.leetcode.easy;

/**
 * 2678. Number of Senior Citizens
 * https://leetcode.com/problems/number-of-senior-citizens/description/
 */
public class NumberOfSeniorCitizens {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 42.36 MB Beats 70.25%
     */
    public int countSeniors(String[] details) {
        int count = 0;

        for (int i = 0; i < details.length; i++) {
            char firstAgeDigit = details[i].charAt(11);
            if ('6' == firstAgeDigit) {
                char secondAgeDigit = details[i].charAt(12);
                if (secondAgeDigit != '0') {
                    count++;
                    continue;
                }
            }
            if ('6' < firstAgeDigit && firstAgeDigit <= '9') {
                count++;
            }
        }

        return count;
    }
}
