package ru.femirion.leetcode.medium;

/**
 * 1493. Longest Subarray of 1's After Deleting One Element
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 */
public class LongestSubarrayOf1SAfterDeletingOneElement {

    /**
     * Runtime 3 ms Beats 75.46% of users with Java
     * Memory 56.37 MB Beats 82.97% of users with Java
     */
    public int longestSubarray(int[] nums) {
        int p = 0;
        int q = 0;
        boolean wasDeleted = false;
        int curLength = 0;
        int maxLength = 0;

        boolean isOnly1 = true;

        while (p < nums.length && q < nums.length) {
            if (nums[q] == 1) {
                curLength++;
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                q++;
            } else {
                isOnly1 = false;
                if (!wasDeleted) {
                    wasDeleted = true;
                    q++;
                } else {
                    if (nums[p] == 0) {
                        wasDeleted = false;
                    } else {
                        curLength--;
                    }
                    p++;
                }
            }
        }
        return isOnly1 ? nums.length - 1 : maxLength;
    }
}
