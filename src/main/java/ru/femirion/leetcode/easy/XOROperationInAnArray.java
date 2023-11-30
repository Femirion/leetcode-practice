package ru.femirion.leetcode.easy;

/**
 * 1486. XOR Operation in an Array
 * https://leetcode.com/problems/xor-operation-in-an-array/
 */
public class XOROperationInAnArray {

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 39.98MB Beats 6.39% of users with Java
     */
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];

        int result = start;
        for (int i = 1; i < n; i++) {
            nums[i] = start + 2 * i;
            result = result ^ nums[i];
        }
        return result;
    }

}
