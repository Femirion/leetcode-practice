package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 */
public class ContainsDuplicateII {

    /**
     * Runtime 17 ms Beats 85.29% of users with Java
     * Memory 58.16 MB Beats 13.64% of users with Java
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            Integer idx = map.get(current);
            if (idx == null) {
                map.put(current, i);
            } else {
                if (Math.abs(i - idx) <= k) {
                    return true;
                }
                map.put(current, i);
            }
        }
        return false;
    }
}
