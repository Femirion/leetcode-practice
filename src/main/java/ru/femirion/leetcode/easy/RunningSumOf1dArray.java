package ru.femirion.leetcode.easy;

/**
 * 1480. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/description/
 */
public class RunningSumOf1dArray {

    /**
     * Runtime 0 ms Beats 100.00%  of users with Java
     * Memory 42.34 MB Beats 69.43% of users with Java
     */
    public int[] runningSum(int[] nums) {
        int sum = nums[0];
        int[] arr = new int[nums.length];
        arr[0] = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];
            arr[i] = sum;
        }
        return arr;
    }
}
