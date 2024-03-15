package ru.femirion.leetcode.easy;

/**
 * 1512. Number of Good Pairs
 * https://leetcode.com/problems/number-of-good-pairs/description/
 */
public class NumberOfGoodPairs {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.03 MB Beats 36.30% of users with Java
     */
    public int numIdenticalPairs(int[] nums) {
        int[] arr = new int[201];

        int pairsCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int val = arr[cur + 100];
            if (val != 0) {
                pairsCount = pairsCount + val;
            }
            arr[cur + 100] = val + 1;
        }
        return pairsCount;
    }
}
