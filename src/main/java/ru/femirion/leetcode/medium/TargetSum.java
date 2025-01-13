package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/description/
 */
public class TargetSum {

    /**
     * Runtime 647 ms Beats 11.57%
     * Memory 41.68 MB Beats 61.92%
     */
    public int findTargetSumWays(int[] nums, int target) {
        return backtracking(nums, 0, target, 0, 0);
    }

    private int backtracking(int[] nums, int idx, int target, int curSum, int count) {
        if (nums.length <= idx) {
            if (curSum == target) {
                return count + 1;
            } else {
                return count;
            }
        }

        int tmpMinus = -nums[idx];
        int tmpPlus = nums[idx];

        int minusResult = backtracking(nums, idx + 1, target, curSum + tmpMinus, count);
        int plusResult = backtracking(nums, idx + 1, target, curSum + tmpPlus, count);

        return minusResult + plusResult;
    }

    public static class Memo {
        /**
         * Runtime 111 ms Beats 41.54%
         * Memory 45.61 MB Beats 8.16%
         */
        public int findTargetSumWays(int[] nums, int target) {
            Map<String, Integer> memo = new HashMap<>();
            return backtracking(nums, 0, target, 0, memo);
        }

        private int backtracking(int[] nums, int idx, int target, int curSum, Map<String, Integer> memo) {
            String key = idx + "," + curSum;

            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            if (nums.length <= idx) {
                return curSum == target ? 1 : 0;
            }

            int minusResult = backtracking(nums, idx + 1, target, curSum - nums[idx], memo);
            int plusResult = backtracking(nums, idx + 1, target, curSum + nums[idx], memo);

            int result = minusResult + plusResult;
            memo.put(key, result);

            return result;
        }
    }
}
