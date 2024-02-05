package ru.femirion.leetcode.easy;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class SearchInsertPosition {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 43.14 MB Beats 36.00% of users with Java
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int currentIdx = (end - start) / 2;
        int current;

        while (start <= end) {
            current = nums[currentIdx];
            if (current == target) {
                return currentIdx;
            }
            if (end - start == 1 || end == start) {
                if (start == 0 && nums[0] > target) {
                    return 0;
                }
                if (end == nums.length - 1) {
                    if (nums[nums.length - 1] > target) {
                        return end + 1;
                    } else {
                        return end;
                    }
                }

                return end;
            }
            if (target < current) {
                end = currentIdx;
                currentIdx = start + ((end - start) / 2);
            } else {
                start = currentIdx;
                currentIdx = end - ((end - start) / 2);
            }
        }

        return -1;
    }
}
