package ru.femirion.leetcode.medium;

/**
 * 1004. Max Consecutive Ones III
 */
public class MaxConsecutiveOnesIII {

    /**
     * Runtime 3 ms Beats 79.60% of users with Java
     * Memory 46.32 MB Beats 96.45% of users with Java
     */
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int currentLength = 0;
        int totalFlip = 0;

        int p = 0;
        int q = 0;
        while (p < nums.length && q < nums.length) {
            if (nums[q] == 1) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                q++;
            } else {
                if (totalFlip < k) {
                    currentLength++;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                    totalFlip++;
                    q++;
                } else {
                    if (nums[p] == 1) {
                        currentLength--;
                    } else {
                        currentLength--;
                        totalFlip--;
                    }
                    p++;
                }
            }
        }
        return maxLength;
    }
}
