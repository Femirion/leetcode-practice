package ru.femirion.leetcode.medium;

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class MinimumSizeSubarraySum {

    /**
     * Runtime 1 ms Beats 99.72%
     * Memory 54.50 MB Beats 99.17%
     */
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;

        int minLength = Integer.MAX_VALUE;
        int curSum = 0;
        while (start < nums.length) {
            if (curSum < target) {
                if (end < nums.length) {
                    curSum = curSum + nums[end];
                    end++;
                } else {
                    curSum = curSum - nums[start];
                    start++;
                }
            } else {
                minLength = Math.min(minLength, end - start);
                curSum = curSum - nums[start];
                start++;
            }
        }

        if (target <= curSum) {
            minLength = Math.min(minLength, end - start);
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
