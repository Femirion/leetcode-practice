package ru.femirion.leetcode.medium;

/**
 * 2340. Minimum Adjacent Swaps to Make a Valid Array
 * https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/description/
 */
public class MinimumAdjacentSwapsToMakeAValidArray {

    /**
     * Runtime 2 ms Beats 90.87%
     * Memory 57.05 MB Beats 62.99%
     */
    public int minimumSwaps(int[] nums) {
        int minElem = Integer.MAX_VALUE;
        int maxElem = Integer.MIN_VALUE;
        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            int curElem = nums[i];
            if (curElem < minElem) {
                minElem = curElem;
                minIdx = i;
            }
            if (maxElem <= curElem) {
                maxElem = curElem;
                maxIdx = i;
            }
        }
        if (maxElem == minElem) {
            return 0;
        }

        int result = minIdx + (nums.length - 1 - maxIdx);
        if (maxIdx < minIdx) {
            result--;
        }
        return result;
    }
}
