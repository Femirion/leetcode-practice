package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 1679. Max Number of K-Sum Pairs
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/description/
 */
public class MaxNumberOfKSumPairs {

    /**
     * Runtime 18 ms Beats 94.16% of users with Java
     * Memory 57.52 MB Beats 30.00% of users with Java
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int p = 0;
        int q = nums.length - 1;
        int sum = 0;
        int result = 0;

        while (p < q) {
            sum = nums[p] + nums[q];
            if (sum == k) {
                p++;
                q--;
                result++;
                continue;
            }
            if (sum > k) {
                q--;
            } else {
                p++;
            }
        }
        return result;
    }
}
