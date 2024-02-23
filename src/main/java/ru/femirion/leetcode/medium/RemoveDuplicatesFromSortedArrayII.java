package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */
public class RemoveDuplicatesFromSortedArrayII {
    /**
     * Runtime 2 ms Beats 11.37% of users with Java
     * Memory 44.43 MB Beats 51.47% of users with Java
     */
    public int removeDuplicates(int[] nums) {
        int result = 0;

        int w = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int counts;
        for (int i = 0; i < nums.length; i++) {
            counts = map.getOrDefault(nums[i], 0);
            if (counts <= 1) {
                nums[w] = nums[i];
                result++;
                w++;
                map.put(nums[i], counts + 1);
            }
        }
        return result;
    }
}
