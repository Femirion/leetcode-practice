package ru.femirion.leetcode.easy;

/**
 * 2239. Find Closest Number to Zero
 * https://leetcode.com/problems/find-closest-number-to-zero/
 */
public class FindClosestNumberToZero {

    /**
     * Runtime 2ms Beats 88.55%of users with Java
     * Memory 44.80MB Beats 5.42%of users with Java
     */
    public int findClosestNumber(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            int absResult = Math.abs(result);
            if (absResult == current) {
                if (nums[i] > result) {
                    result = nums[i];
                }
            }
            if (absResult > current) {
                result = nums[i];
            }
        }
        return result;
    }

}
