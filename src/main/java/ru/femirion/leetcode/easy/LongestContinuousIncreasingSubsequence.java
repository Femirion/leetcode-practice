package ru.femirion.leetcode.easy;

/**
 * 674. Longest Continuous Increasing Subsequence
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 */
public class LongestContinuousIncreasingSubsequence {

    /**
     * Runtime 1 ms Beats 99.66% of users with Java
     * Memory 44.40 MB Beats 37.98% of users with Java
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int max = 0;
        int currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
                max = Math.max(currentLength, max);
            } else {
                max = Math.max(currentLength, max);
                currentLength = 0;
            }
        }
        return max;
    }
}
