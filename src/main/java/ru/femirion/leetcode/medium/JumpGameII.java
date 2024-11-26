package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/description/
 */
public class JumpGameII {

    /**
     * Runtime 50 ms Beats 12.47%
     * Memory 45.92 MB Beats 6.34%
     */
    public int jump2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 10000001);

        dp[nums.length - 1] = 0;

        int idx = nums.length - 2;

        while (0 <= idx) {
            for (int i = idx + 1; i <= Math.min(idx + nums[idx], nums.length - 1); i++) {
                dp[idx] = Math.min(dp[idx], dp[i]);
            }
            dp[idx]++;
            idx--;
        }


        return dp[0];
    }

    /**
     * Runtime 1 ms Beats 99.12%
     * Memory 44.99 MB Beats 65.32%
     */
    public int jump(int[] nums) {
        int steps = nums[0];

        if (nums.length == 1) {
            return 0;
        }

        int idx = 0;
        int count = 1;

        while(0 < steps) {
            if (nums.length - 1 <= idx) {
                return count;
            }

            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            int end = idx + steps;
            int diff = Integer.MIN_VALUE;
            if (nums.length - 1 <= end) {
                return count;
            }
            for (int i = idx + 1; i <= end; i++) {
                int curDiff = nums[i] - (end - i);
                if (diff <= curDiff) {
                    max = nums[i];
                    maxIdx = i;
                    diff = curDiff;
                }
            }
            steps = max;
            idx = maxIdx;
            count++;
        }
        return count;
    }
}
