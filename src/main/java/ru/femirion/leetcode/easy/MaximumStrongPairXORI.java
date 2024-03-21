package ru.femirion.leetcode.easy;

/**
 * 2932. Maximum Strong Pair XOR I
 * https://leetcode.com/problems/maximum-strong-pair-xor-i/description/
 *
 * #BitManipulation
 */
public class MaximumStrongPairXORI {

    /**
     * Runtime 2 ms Beats 95.32% of users with Java
     * Memory 42.53 MB Beat 94.93% of users with Java
     */
    public int maximumStrongPairXor(int[] nums) {
        int maxXor = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                    int xor = nums[i] ^ nums[j];
                    if (xor > maxXor) {
                        maxXor = xor;
                    }
                }
            }
        }
        return maxXor;
    }
}
