package ru.femirion.leetcode.easy;

/**
 * 2210. Count Hills and Valleys in an Array
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array/description/
 */
public class CountHillsAndValleysInAnArray {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.47 MB Beats 49.09%
     */
    public int countHillValley(int[] nums) {
        int result = 0;
        int prev = -1;
        int next = -1;
        for (int i = 1; i < nums.length - 1; i++) {
            int p = i - 1;
            int q = i + 1;
            prev = nums[p];
            if (prev == nums[i]) {
                continue;
            }
            next = nums[q];
            while (nums[i] == next && q < nums.length - 1) {
                q++;
                next = nums[q];
            }
            if (next == nums[i]) {
                break;
            }

            if (prev < nums[i] && next < nums[i]) {
                result++;
            }
            if (nums[i] < prev && nums[i] < next) {
                result++;
            }
        }
        return result;
    }
}
