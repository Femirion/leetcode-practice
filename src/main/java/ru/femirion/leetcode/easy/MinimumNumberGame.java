package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 2974. Minimum Number Game
 * https://leetcode.com/problems/minimum-number-game/description/
 */
public class MinimumNumberGame {

    /**
     * Runtime 2 ms Beats 98.21%
     * Memory 44.70 MB Beats 79.42%
     */
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i = i + 2) {
            result[i] = nums[i + 1];
            result[i + 1] = nums[i];
        }

        return result;
    }
}
