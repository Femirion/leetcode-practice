package ru.femirion.leetcode.medium;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 */
public class SortColors {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.80 MB Beats 27.11%
     */
    public void sortColors2(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = nums.length - 1;

        while (white <= blue) {
            if (nums[white] == 0) {
                int tmp = nums[white];
                nums[white] = nums[red];
                nums[red] = tmp;
                red++;
                white++;
            } else if (nums[white] == 1) {
                white++;
            } else {
                int tmp = nums[white];
                nums[white] = nums[blue];
                nums[blue] = tmp;
                blue--;
            }
        }
    }

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
