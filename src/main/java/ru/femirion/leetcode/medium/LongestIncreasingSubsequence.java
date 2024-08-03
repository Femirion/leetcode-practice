package ru.femirion.leetcode.medium;

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    /**
     * Runtime 35 ms Beats 80.49%
     * Memory 43.89 MB Beats 83.27%
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int[] results = new int[nums.length];
        results[nums.length - 1] = 1;

        for (int i = nums.length - 1; 0 <= i; i--) {
            int prevMax = 1;
            for (int j = i; j < nums.length; j++) {
                var numsI = nums[i];
                var numsJ = nums[j];
                var resultsJ = results[j];
                if (prevMax <= results[j] && nums[i] < nums[j]) {
                    prevMax = results[j] + 1;
                }
            }
            results[i] = prevMax;
        }

        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (max < results[i]) {
                max = results[i];
            }
        }
        return max;
    }
}
