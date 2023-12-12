package ru.femirion.leetcode.easy;

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

    /**
     * Runtime 1ms Beats 99.95% of users with Java
     * Memory 45.09MB Beats 13.89% of users with Java
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return  result;
    }
}
