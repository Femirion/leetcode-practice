package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * <p>
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
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
