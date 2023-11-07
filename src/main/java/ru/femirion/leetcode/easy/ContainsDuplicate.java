package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            boolean isDuplicate = numbers.contains(current);
            if (isDuplicate) {
                return true;
            }
            numbers.add(current);
        }
        return false;
    }
}
