package ru.femirion.leetcode.medium;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 46.21 MB Beats 15.64%
     */
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = {-1, -1};

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    result[0] = mid;
                    start = mid;
                    break;
                } else {
                    end--;
                    continue;
                }
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (result[0] == -1) {
            return result;
        }

        end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || target < nums[mid + 1]) {
                    result[1] = mid;
                    break;
                } else {
                    start++;
                    continue;
                }
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
