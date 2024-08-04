package ru.femirion.leetcode.easy;

/**
 * 3105. Longest Strictly Increasing or Strictly Decreasing Subarray
 * https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/
 */
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    /**
     * Runtime 1 ms Beats 90.00%
     * Memory 42.95 MB Beats 11.96%
     */
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int min = 1;

        int curMin = 1;
        int curMax = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                curMax++;
                if (max < curMax) {
                    max = curMax;
                }
                curMin = 1;
                continue;
            }
            if (nums[i] < nums[i - 1]) {
                curMin++;
                if (min < curMin) {
                    min = curMin;
                }
                curMax = 1;
            } else {
                if (max < curMax) {
                    max = curMax;
                }
                if (min < curMin) {
                    min = curMin;
                }
                curMin = 1;
                curMax = 1;
            }
        }

        return Math.max(max, min);
    }
}
