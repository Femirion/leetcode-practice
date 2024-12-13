package ru.femirion.leetcode.hard;

import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 */
public class ContainsDuplicateIII {

    /**
     * Runtime 120 ms Beats 62.18%
     * Memory 62.82 MB Beats 30.46%
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> tree = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Integer lower = tree.ceiling(nums[i] - valueDiff);

            if (lower != null && (lower <= valueDiff + nums[i])) {
                return true;
            }

            tree.add(nums[i]);
            if (indexDiff < tree.size()) {
                tree.remove(nums[i - indexDiff]);
            }
        }

        return false;
    }
}
