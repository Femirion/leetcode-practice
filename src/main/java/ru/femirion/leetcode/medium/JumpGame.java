package ru.femirion.leetcode.medium;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {

    /**
     * Runtime 3 ms Beats 48.04%
     * Memory 45.92 MB Beats 15.63%
     */
    public boolean canJump(int[] nums) {
        int steps = nums[0];

        if (nums.length == 1) {
            return true;
        }

        int idx = 0;

        while (0 < steps) {
            if (nums.length - 1 <= idx) {
                return true;
            }

            int max = Integer.MIN_VALUE;
            int maxIdx = -1;
            int end = idx + steps;
            int diff = Integer.MIN_VALUE;
            if (nums.length - 1 <= end) {
                return true;
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
        }
        return false;
    }
}
