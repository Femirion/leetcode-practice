package ru.femirion.leetcode.easy;

import java.util.List;

/**
 * 2859. Sum of Values at Indices With K Set Bits
 * https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description/
 */
public class SumOfValuesAtIndicesWithKSetBits {

    /**
     * Runtime 1 ms Beats 100.00% of users with Java
     * Memory 44.33 MB Beats 52.42% of users with Java
     */
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (k == Integer.bitCount(i)) {
                result = result + nums.get(i);
            }
        }
        return result;
    }
}
