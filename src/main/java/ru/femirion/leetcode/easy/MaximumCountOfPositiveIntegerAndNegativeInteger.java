package ru.femirion.leetcode.easy;

/**
 * 2529. Maximum Count of Positive Integer and Negative Integer
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
 */
public class MaximumCountOfPositiveIntegerAndNegativeInteger {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 44.99 MB Beats 64.38%
     */
    public int maximumCount(int[] nums) {
        int negative = binarySearch(nums, 0);
        int positive = nums.length - binarySearch(nums, 1);

        return Math.max(negative, positive);
    }

    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = nums.length;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}
