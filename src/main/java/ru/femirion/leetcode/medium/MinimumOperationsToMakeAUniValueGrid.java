package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 2033. Minimum Operations to Make a Uni-Value Grid
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/
 */
public class MinimumOperationsToMakeAUniValueGrid {

    /**
     * Runtime 34 ms Beats 90.45%
     * Memory 77.64 MB Beats 37.69%
     */
    public int minOperations(int[][] grid, int x) {
        int[] nums = new int[grid.length * grid[0].length];

        int idx = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                nums[idx] = grid[i][j];
                idx++;
            }
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[0]) % x != 0) {
                return -1;
            }
        }

        int median = nums[nums.length / 2];
        int operations = 0;

        for (int num : nums) {
            operations = operations + Math.abs(num - median) / x;
        }

        return operations;
    }
}
