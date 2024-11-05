package ru.femirion.leetcode.easy;

/**
 * 3065. Minimum Operations to Exceed Threshold Value I
 * https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/description/
 */
public class MinimumOperationsToExceedThresholdValueI {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 42.94 MB Beats 25.13%
     */
    public int minOperations(int[] nums, int k) {
        int result = 0;

        for (int num : nums) {
            if (num < k) {
                result++;
            }
        }

        return result;
    }
}
