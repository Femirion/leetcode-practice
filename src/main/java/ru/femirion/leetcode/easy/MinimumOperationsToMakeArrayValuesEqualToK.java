package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 3375. Minimum Operations to Make Array Values Equal to K
 * https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/
 */
public class MinimumOperationsToMakeArrayValuesEqualToK {

    /**
     * Runtime 3 ms Beats 52.54%
     * Memory 44.26 MB Beats 89.49%
     */
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);

        if (nums[0] < k) {
            return -1;
        }

        int result = 0;

        for (int i = nums.length - 2; 0 <= i; i--) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] < k) {
                return -1;
            }
            result++;
        }

        if (nums[0] != k) {
            result++;
        }


        return result;
    }
}
