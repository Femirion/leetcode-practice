package ru.femirion.leetcode.easy;

/**
 * 1979. Find Greatest Common Divisor of Array
 * https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 */
public class FindGreatestCommonDivisorOfArray {

    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 42.84MB Beats 58.26% of users with Java
     */
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current < min) {
                min = current;
                continue;
            }
            if (max < current) {
                max = current;
            }
        }
        for (int i = min; i > 0; i--) {
            if (max % i == 0 && min % i == 0) {
                return i;
            }
        }
        return 0;
    }
}
