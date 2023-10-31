package ru.femirion.leetcode.easy;

/**
 * 747. Largest Number At Least Twice of Others
 *
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 *
 * You are given an integer array nums where the largest integer is unique.
 *
 * Determine whether the largest element in the array is at least twice as much as every other number in the array.
 * If it is, return the index of the largest element, or return -1 otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,1,0]
 * Output: 1
 * Explanation: 6 is the largest integer.
 * For every other number in the array x, 6 is at least twice as big as x.
 * The index of value 6 is 1, so we return 1.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: -1
 * Explanation: 4 is less than twice the value of 3, so we return -1.
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * The largest element in nums is unique.
 */
public class LargestNumberAtLeastTwiceOfOthers {

    /**
     * 0ms Beats 100.00%of users with Java
     * 39.41MB Beats 99.63%of users with Java
     */
    public int dominantIndex(int[] nums) {
        int max = -1;
        int dominantIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current >= max) {
                max = current;
                dominantIdx = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (i == dominantIdx || current == 0) {
                continue;
            }
            if (max / current < 2) {
                return -1;
            }
        }
        return dominantIdx;
    }

}
