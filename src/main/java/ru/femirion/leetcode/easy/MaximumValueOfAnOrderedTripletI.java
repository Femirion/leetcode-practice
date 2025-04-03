package ru.femirion.leetcode.easy;

/**
 * 2873. Maximum Value of an Ordered Triplet I
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/
 */
public class MaximumValueOfAnOrderedTripletI {

    /**
     * Runtime 1 ms Beats 99.32%
     * Memory 42.12 MB Beats 42.69%
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
