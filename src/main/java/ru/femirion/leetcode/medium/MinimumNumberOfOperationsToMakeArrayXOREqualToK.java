package ru.femirion.leetcode.medium;

/**
 * 2997. Minimum Number of Operations to Make Array XOR Equal to K
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/
 */
public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {

    /**
     * Runtime 1 ms Beats 100.00%
     * Memory 57.98 MB Beats 72.68%
     */
    public int minOperations(int[] nums, int k) {
        int xorTotal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xorTotal = xorTotal ^ nums[i];
        }

        int result = 0;
        for (int i = 0; i < 30; i++) {
            int kCurBit = 1 << i & k;
            int xorTotalCurBit = 1 << i & xorTotal;
            if (kCurBit != xorTotalCurBit) {
                result++;
            }
        }
        return result;
    }
}
