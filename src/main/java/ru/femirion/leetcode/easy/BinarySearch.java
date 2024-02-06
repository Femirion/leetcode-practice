package ru.femirion.leetcode.easy;

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/description/
 */
public class BinarySearch {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 45.87 MB Beats 24.25% of users with Java
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int currentIdx;
        int current;

        while (start <= end) {
            currentIdx = start + ((end - start) / 2);
            current = nums[currentIdx];
            if (current == target) {
                return currentIdx;
            }
            if (current < target) {
                start = currentIdx + 1;
            } else {
                end = currentIdx - 1;
            }
        }

        return -1;
    }
}
