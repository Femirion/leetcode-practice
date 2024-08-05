package ru.femirion.leetcode.medium;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.85 MB Beats 26.74%
     */
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redCount++;
                continue;
            }
            if (nums[i] == 1) {
                whiteCount++;
                continue;
            }
            if (nums[i] == 2) {
                blueCount++;
            }
        }

        int i = 0;
        while (0 < redCount) {
            nums[i] = 0;
            i++;
            redCount--;
        }
        while (0 < whiteCount) {
            nums[i] = 1;
            i++;
            whiteCount--;
        }
        while (0 < blueCount) {
            nums[i] = 2;
            i++;
            blueCount--;
        }
    }
}
