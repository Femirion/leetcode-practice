package ru.femirion.leetcode.medium;

/**
 * 2874. Maximum Value of an Ordered Triplet II
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/
 */
public class MaximumValueOfAnOrderedTripletII {

    /**
     * Runtime 2 ms Beats 97.85%
     * Memory 57.51 MB Beats 60.22%
     */
    public long maximumTripletValue(int[] nums) {
        long maxLeft = 0;
        long maxDiff = 0;
        long result = 0;

        for (int i = 1; i < nums.length; i++) {
            maxLeft = Math.max(maxLeft, nums[i - 1]);
            result = Math.max(result, maxDiff * nums[i]);
            maxDiff = Math.max(maxDiff, maxLeft - nums[i]);
        }

        return result;
    }
}
