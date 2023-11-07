package ru.femirion.leetcode.easy;

/**
 * 747. Largest Number At Least Twice of Others
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
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
