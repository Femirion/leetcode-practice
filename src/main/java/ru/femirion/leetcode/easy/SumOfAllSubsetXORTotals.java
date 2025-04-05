package ru.femirion.leetcode.easy;

/**
 * 1863. Sum of All Subset XOR Totals
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/
 */
public class SumOfAllSubsetXORTotals {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 40.53 MB Beats 98.41%
     */
    public int subsetXORSum(int[] nums) {
        return backtracking(nums, 0, 0);
    }

    private int backtracking(int[] nums, int curIdx, int total) {
        if (curIdx == nums.length) {
            return total;
        }

        int exclude = backtracking(nums, curIdx + 1, total);
        int include = backtracking(nums, curIdx + 1, total ^ nums[curIdx]);

        return exclude + include;
    }
}
