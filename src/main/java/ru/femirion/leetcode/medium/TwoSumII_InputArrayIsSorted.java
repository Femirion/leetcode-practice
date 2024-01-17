package ru.femirion.leetcode.medium;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumII_InputArrayIsSorted {

    /**
     * Runtime 2 ms Beats 89.59% of users with Java
     * Memory 47.28 MB Beats 16.11% of users with Java
     */
    public int[] twoSum(int[] numbers, int target) {
        int p = 0;
        int q = numbers.length - 1;
        while (p < q) {
            int sum = numbers[p] + numbers[q];
            if (sum == target) {
                return new int[]{p + 1, q + 1};
            }
            if (sum > target) {
                q--;
            } else {
                p++;
            }
        }
        return null;
    }

}
