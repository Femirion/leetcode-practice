package ru.femirion.leetcode.medium;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaximumSubarray {

    /**
     * Runtime 1 ms Beats 99.49%
     * Memory 56.90 MB Beats 70.15%
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        int start = 0;
        int end = 0;

        while (end < nums.length) {
            curSum = curSum + nums[end];
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0) {
                while (start <= end) {
                    curSum = curSum - nums[start];
                    if (curSum < 0) {
                        start++;
                    } else {
                        break;
                    }
                }
                if (start == end) {
                    start++;
                    end++;
                    continue;
                }
            }
            end++;
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
