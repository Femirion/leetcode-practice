package ru.femirion.leetcode.medium;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.61 MB Beats 84.60%
     */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start <= end) {
            mid = start + ((end - start) / 2);
            int midE = nums[mid];


            if (mid == 0 && nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            }

            if ((nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }

            if (nums[nums.length - 1] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
    }
}
