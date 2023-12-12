package ru.femirion.leetcode.easy;

/**
 * 1827. Minimum Operations to Make the Array Increasing
 * https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
 */
public class MinimumOperationsToMakeTheArrayIncreasing {

    /**
     * Runtime 4ms Beats 52.79% of users with Java
     * Memory 44.30MB Beats 18.53% of users with Java
     */
    public int minOperations(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                int difference = (nums[i] - nums[i + 1]) + 1;
                nums[i + 1] = nums[i + 1] + difference;
                result = result + difference;
                continue;
            }
            if (nums[i + 1] == nums[i]) {
                nums[i + 1] = nums[i + 1] + 1;
                result = result + 1;
            }
        }
        return result;
    }

}
