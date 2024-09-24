package ru.femirion.leetcode.easy;

/**
 * 3173. Bitwise OR of Adjacent Elements
 * https://leetcode.com/problems/bitwise-or-of-adjacent-elements/description/
 */
public class BitwiseOROfAdjacentElements {

    /**
     * Runtime 1 ms Beats 100.00%
     * Memory 45.24 MB Beats 86.34%
     */
    public int[] orArray(int[] nums) {
        int[] result = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            result[i] = nums[i] | nums[i + 1];
        }


        return result;
    }
}
