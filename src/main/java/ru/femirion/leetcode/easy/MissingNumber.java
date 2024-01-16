package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber {

    /**
     * Runtime 7 ms Beats 9.91% of users with Java
     * Memory 45.42 MB Beats 14.28% of users with Java
     */
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }
        return new ArrayList<>(set).get(0);
    }

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 45.65 MB Beats 6.06% of users with Java
     */
    public int missingNumber1(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + i;
        }

        for (int i = 0; i < nums.length; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }

}
