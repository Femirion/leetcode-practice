package ru.femirion.leetcode.easy;

/**
 * 2843. Count Symmetric Integers
 * https://leetcode.com/problems/count-symmetric-integers/submissions/
 */
public class CountSymmetricIntegers {

    /**
     * Runtime 6 ms Beats 99.57% Analyze Complexity
     * Memory 41.11 MB Beats 98.27%
     */
    public int countSymmetricIntegers(int low, int high) {
        int result = 0;

        for (int i = low; i <= high; i++) {
            if (i <= 9 || (100 <= i && i <= 999) || i == 10000) {
                continue;
            }
            int first = i / 1000;
            int second = (i - first * 1000) / 100;
            int third = (i - first * 1000 - second * 100) / 10;
            int fourth = i - first * 1000 - second * 100 - third * 10;

            if (i <= 99) {
                if (third == fourth) {
                    result++;
                }
                continue;
            }

            if (first + second == third + fourth) {
                result++;
            }
        }

        return result;
    }
}
