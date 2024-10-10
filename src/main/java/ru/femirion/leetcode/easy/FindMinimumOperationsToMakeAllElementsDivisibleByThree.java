package ru.femirion.leetcode.easy;

/**
 * 3190. Find Minimum Operations to Make All Elements Divisible by Three
 * https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/
 */
public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 42.06 MB Beats 23.02%
     */
    public int minimumOperations(int[] nums) {
        int result = 0;

        for (int num : nums) {
            int div = num % 3;
            if (div == 0) {
                continue;
            }
            result++;
        }

        return result;
    }
}
