package ru.femirion.leetcode.easy;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Runtime: 1 ms, faster than 87.61% of Java online submissions for Remove Duplicates from Sorted Array.
     * Memory Usage: 43.8 MB, less than 89.00% of Java online submissions for Remove Duplicates from Sorted Array.
     */
    public int removeDuplicates(int[] nums) {
        int result = 1;

        if (nums.length == 1) {
            return result;
        }

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int prev = nums[i - 1];

            if (current != prev) {
                nums[result] = current;
                result++;
            }
        }

        return result;
    }
}
