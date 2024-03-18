package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 1913. Maximum Product Difference Between Two Pairs
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/
 */
public class MaximumProductDifferenceBetweenTwoPairs {

    /**
     * Runtime 7 ms Beats 66.52% of users with Java
     * Memory 45.08 MB Beats 44.05% of users with Java
     */
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
    }
}
