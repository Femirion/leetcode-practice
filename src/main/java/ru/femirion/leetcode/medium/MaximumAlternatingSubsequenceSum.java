package ru.femirion.leetcode.medium;

/**
 * 1911. Maximum Alternating Subsequence Sum
 * https://leetcode.com/problems/maximum-alternating-subsequence-sum/description/
 */
public class MaximumAlternatingSubsequenceSum {

    /**
     * Runtime 4 ms Beats 98.23%
     * Memory 59.49 MB Beats 89.76%
     */
    public long maxAlternatingSum(int[] nums) {
        long result = 0;

        int prev = nums[0];
        boolean isOdd = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prev) {
                if (isOdd) {
                    result = result + prev;
                    prev = nums[i];
                    isOdd = false;
                } else {
                    prev = nums[i];
                }
            } else {
                if (!isOdd) {
                    result = result - prev;
                    prev = nums[i];
                    isOdd = true;
                } else {
                    prev = nums[i];
                }
            }
        }

        if (isOdd) {
            result = result + prev;
        }
        return result;
    }
}
