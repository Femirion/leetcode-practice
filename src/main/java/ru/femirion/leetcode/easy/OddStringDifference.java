package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 2451. Odd String Difference
 * https://leetcode.com/problems/odd-string-difference/description/
 */
public class OddStringDifference {

    /**
     * Runtime 0ms Beats 100.00%of users with Java
     * Memory 39.85MB Beats 81.90%of users with Java
     */
    public String oddString(String[] words) {
        int[] counters = new int[words.length];
        for (int j = 0; j < words[0].length() - 1; j++) {
            for (int k = 0; k < words.length; k++) {
                int result = words[k].charAt(j + 1) - words[k].charAt(j);
                counters[k] = result;
            }
            int first = counters[0];
            int second = counters[1];
            int third = counters[2];
            if (first != second) {
                if (first != third) {
                    return words[0];
                } else {
                    return words[1];
                }
            }
            for (int i = 2; i < counters.length; i++) {
                if (counters[i] != first) {
                    return words[i];
                }
            }
            Arrays.fill(counters, 0);
        }
        return "";
    }

}
