package ru.femirion.leetcode.medium;

/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/description/
 */
public class JumpGameII {

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
