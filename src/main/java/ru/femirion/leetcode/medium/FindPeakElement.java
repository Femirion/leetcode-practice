package ru.femirion.leetcode.medium;

/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/description/
 */
public class FindPeakElement {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 42.09 MB Beats 84.76% of users with Java
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        int start = 0;
        int end = nums.length - 1;
        int curIdx = 0;
        int cur;
        int prev;
        int next;

        while (start <= end) {
            curIdx = start + ((end - start) / 2);
            cur = nums[curIdx];

            if (curIdx - 1 >= 0) {
                prev = nums[curIdx - 1];
            } else {
                prev = Integer.MIN_VALUE;
            }

            if (curIdx + 1  < nums.length) {
                next = nums[curIdx + 1];
            } else {
                next = Integer.MIN_VALUE;
            }

            if (prev < cur && next < cur) {
                return curIdx;
            }

            if (cur < prev && next < cur) {
                end = curIdx - 1;
            } else {
                start = curIdx + 1;
            }
        }
        return curIdx;
    }
}
