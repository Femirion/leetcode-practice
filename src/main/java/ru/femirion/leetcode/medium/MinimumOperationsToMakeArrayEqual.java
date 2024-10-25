package ru.femirion.leetcode.medium;

/**
 * 1551. Minimum Operations to Make Array Equal
 * https://leetcode.com/problems/minimum-operations-to-make-array-equal/description/
 */
public class MinimumOperationsToMakeArrayEqual {

    /**
     * Runtime 1 ms Beats 52.39%
     * Memory 40.37 MB Beats 72.04%
     */
    public int minOperations(int n) {
        int first = 1;
        int last = (n - 1) * 2 + 1;
        int sum = ((first + last) / 2) * n;
        int mediane = sum / n;

        int result = 0;
        int end = n % 2 == 0 ? n/2 - 1 : n/2;
        for (int i = 0; i <= end; i++) {
            result = result + (mediane - (i * 2 + 1));
        }
        return result;
    }
}
