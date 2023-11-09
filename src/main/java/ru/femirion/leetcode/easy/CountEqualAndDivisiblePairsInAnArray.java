package ru.femirion.leetcode.easy;

/**
 * 2176. Count Equal and Divisible Pairs in an Array
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/description/
 */
public class CountEqualAndDivisiblePairsInAnArray {

    /**
     * Runtime 3ms Beats 99.25% of users with Java
     * Memory 40.97MB Beats 87.85% of users with Java
     */
    public int countPairs(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int n = nums[i];
                int m = nums[j];
                if (n == m) {
                    if (((i * j) % k == 0)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
