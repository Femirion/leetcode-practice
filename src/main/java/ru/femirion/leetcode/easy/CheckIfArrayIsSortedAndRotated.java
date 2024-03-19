package ru.femirion.leetcode.easy;

/**
 * 1752. Check if Array Is Sorted and Rotated
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
 */
public class CheckIfArrayIsSortedAndRotated {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.24 MB Beats 37.05% of users with Java
     */
    public boolean check(int[] nums) {
        boolean hasRotatedPoint = false;
        int prev;
        int cur;
        for (int i = 1; i < nums.length; i++) {
            prev = nums[i - 1];
            cur = nums[i];
            if (cur < prev) {
                if (hasRotatedPoint) {
                    return false;
                }
                hasRotatedPoint = true;
                if (nums[0] < cur) {
                    return false;
                }
            } else {
                if (hasRotatedPoint && nums[0] < cur) {
                    return false;
                }
            }
        }
        return true;
    }
}
