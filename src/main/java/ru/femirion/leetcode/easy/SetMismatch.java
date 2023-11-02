package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 645. Set Mismatch
 *
 * https://leetcode.com/problems/set-mismatch/
 *
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
public class SetMismatch {

    // TODO need to find better solution
    /**
     * Runtime 12ms Beats 17.07%of users with Java
     * Memory 45.45MB Beats 5.63%of users with Java
     */
    public int[] findErrorNums(int[] nums) {
        int[] result = {-1, -1};
        Set<Integer> duplicateSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if (duplicateSet.contains(currentValue)) {
                result[0] = currentValue;
            } else {
                duplicateSet.add(currentValue);
            }
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (!duplicateSet.contains(i)) {
                result[1] = i;
            }
        }
        return result;
    }

}
