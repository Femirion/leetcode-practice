package ru.femirion.leetcode.medium;

/**
 * 487. Max Consecutive Ones II
 * https://leetcode.com/problems/max-consecutive-ones-ii/description/
 */
public class MaxConsecutiveOnesII {

    /**
     * Runtime 2 ms Beats 98.23%
     * Memory 45.2 MB Beats 79.80%
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int q = 0;
        int countBeforeZero = 0;
        int maxCount = 0;
        int curCount = 0;
        boolean wasFlipped = false;

        while (q <= nums.length) {
            if (q < nums.length) {
                if (nums[q] == 1) {
                    curCount++;
                    q++;
                    continue;
                }
            }

            if (maxCount < curCount) {
                maxCount = curCount;
            }

            if (wasFlipped) {
                curCount = curCount - countBeforeZero;
                curCount++;
                countBeforeZero = curCount;
            } else {
                wasFlipped = true;
                curCount++;
                countBeforeZero = curCount;
            }
            q++;
        }

        return maxCount;
    }
}
