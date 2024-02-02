package ru.femirion.leetcode.easy;

/**
 * 896. Monotonic Array
 * https://leetcode.com/problems/monotonic-array/description/
 */
public class MonotonicArray {

    /**
     * Runtime 1 ms Beats 99.31% of users with Java
     * Memory 59.10 MB Beats 48.96% of users with Java
     */
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int i = 1;
        boolean isIncreasing = false;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            isIncreasing = nums[i] > nums[i - 1];
            break;
        }

        for (; i < nums.length; i++) {
            if (isIncreasing) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
