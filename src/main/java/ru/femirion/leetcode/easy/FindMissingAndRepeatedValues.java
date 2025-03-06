package ru.femirion.leetcode.easy;

/**
 * 2965. Find Missing and Repeated Values
 * https://leetcode.com/problems/find-missing-and-repeated-values/description/
 */
public class FindMissingAndRepeatedValues {

    /**
     * Runtime 1 ms Beats 100.00%
     * Memory 45.57 MB Beats 62.19%
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int n = grid.length;


        int[] nums = new int[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[grid[i][j]] != 0) {
                    result[0] = grid[i][j];
                } else {
                    nums[grid[i][j]] = 1;
                }
            }
        }

        for (int i = 1; i < n * n + 1; i++) {
            if (nums[i] == 0) {
                result[1] = i;
                break;
            }
        }

        return result;
    }
}
}
