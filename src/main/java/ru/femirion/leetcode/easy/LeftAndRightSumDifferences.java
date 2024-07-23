package ru.femirion.leetcode.easy;

/**
 * 2574. Left and Right Sum Differences
 * https://leetcode.com/problems/left-and-right-sum-differences/description/
 */
public class LeftAndRightSumDifferences {

    /**
     * Runtime 2 ms Beats 99.13%
     * Memory 44.76 MB Beats 19.01%
     */
    public int[] leftRightDifference(int[] nums) {
        int[] leftSums = new int[nums.length];
        leftSums[0] = 0;
        int[] rigthSums = new int[nums.length];
        rigthSums[0] = 0;

        int p = 1;
        int q = nums.length - 2;
        while (p < nums.length) {
            leftSums[p] = nums[p - 1] + leftSums[p - 1];
            rigthSums[q] = nums[q + 1] + rigthSums[q + 1];
            p++;
            q--;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = Math.abs(leftSums[i] - rigthSums[i]);
        }
        return result;
    }
}
