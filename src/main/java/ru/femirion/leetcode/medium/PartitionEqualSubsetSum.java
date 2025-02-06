package ru.femirion.leetcode.medium;

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class PartitionEqualSubsetSum {

    private Boolean[][] dp;

    /**
     * Runtime 55 ms Beats 40.59%
     * Memory 73.30 MB Beats 6.71%
     */
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total = total + num;
        }

        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;
        dp = new Boolean[nums.length + 1][total + 1];

        return findTargetSum(nums, 0, target, 0);
    }


    private boolean findTargetSum(int[] nums, int idx, int target, int sum) {
        if (idx == nums.length) {
            return false;
        }

        if (target == sum) {
            return true;
        }

        if (dp[idx][sum] != null) {
            return dp[idx][sum];
        }

        dp[idx][sum] = findTargetSum(nums, idx + 1, target, sum + nums[idx])
                || findTargetSum(nums, idx + 1, target, sum);

        return dp[idx][sum];
    }
}
