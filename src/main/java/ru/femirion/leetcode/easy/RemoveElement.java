package ru.femirion.leetcode.easy;

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {
    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 41.66MB Beats 7.72% of users with Java
     */
    public int removeElement(int[] nums, int val) {
        byte w = 0;
        byte r = 0;
        byte result = 0;
        for (byte i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[w] = nums[r];
                w++;
                result++;
            }
            r++;
        }

        for (byte i = w; i < nums.length; i++) {
            nums[w] = 0;
        }
        return result;
    }
}
