package ru.femirion.leetcode.medium;

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobber {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 40.80 MB Beats 53.02%
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = nums[1];

        if (3 <= nums.length) {
            result[2] = nums[0] + nums[2];
        }

        for (int i = 3; i < nums.length; i++) {
            result[i] = Math.max(result[i - 3], result[i - 2]) + nums[i];
        }

        return Math.max(result[result.length - 1], result[result.length - 2]);
    }
}
