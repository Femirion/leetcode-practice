package ru.femirion.leetcode.easy;

/**
 * 2894. Divisible and Non-divisible Sums Difference
 * https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/
 */
public class DivisibleAndNonDivisibleSumsDifference {

    /**
     * Runtime 1 ms Beats 79.94%
     * Memory 40.36 MB Beats 93.35%
     */
    public int differenceOfSums(int n, int m) {
        int divSum = 0;
        int notDivSum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                divSum = divSum + i;
            } else {
                notDivSum = notDivSum + i;
            }
        }
        return notDivSum - divSum;
    }
}
