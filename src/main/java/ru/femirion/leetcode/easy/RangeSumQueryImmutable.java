package ru.femirion.leetcode.easy;

/**
 * 303. Range Sum Query - Immutable
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 */
public class RangeSumQueryImmutable {

    private int[] prefix;

    /**
     * Runtime 7 ms Beats 100.00%
     * Memory 49.94 MB Beats 6.70%
     */
    public RangeSumQueryImmutable(int[] nums) {
        prefix = new int[nums.length + 1];
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum = sum + nums[i - 1];
            prefix[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
