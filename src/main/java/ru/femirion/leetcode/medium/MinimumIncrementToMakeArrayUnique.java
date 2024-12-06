package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 945. Minimum Increment to Make Array Unique
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/
 */
public class MinimumIncrementToMakeArrayUnique {

    /**
     * Runtime 38 ms Beats 44.19%
     * Memory 59.68 MB Beats 35.52%
     */
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i]++;
                count++;
            } if (nums[i] < nums[i - 1]) {
                count = count + (nums[i - 1] - nums[i]) + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }

        return count;
    }
}
