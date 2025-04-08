package ru.femirion.leetcode.easy;

/**
 * 3396. Minimum Number of Operations to Make Elements in Array Distinct
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/
 */
public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {

    /**
     * Runtime 1 ms Beats 98.39%
     * Memory 44.93 MB Beats 12.90%
     */
    public int minimumOperations(int[] nums) {
        int[] existedNums = new int[101];

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (existedNums[nums[i]] != 0) {
                result = Math.max(result, (existedNums[nums[i]] / 3) + 1);
            }
            existedNums[nums[i]] = i == 0 ? 1 : i;
        }

        return result;
    }
}
