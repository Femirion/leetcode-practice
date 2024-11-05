package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 1877. Minimize Maximum Pair Sum in Array
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/
 */
public class MinimizeMaximumPairSumInArray {

    /**
     * Runtime 52 ms Beats 95.19%
     * Memory 58.20 MB Beats 44.96%
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int max = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            max = Math.max(max, nums[left] + nums[right]);
            left++;
            right--;
        }
        return max;
    }
}
