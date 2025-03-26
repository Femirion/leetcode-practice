package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
 */
public class MinimumMovesToEqualArrayElementsII {

    /**
     * Runtime 6 ms Beats 80.94%
     * Memory 44.81 MB Beats 31.53%
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = result + Math.abs(nums[i] - nums[nums.length / 2]);
        }

        return result;
    }
}
