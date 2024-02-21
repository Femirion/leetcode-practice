package ru.femirion.leetcode.easy;

/**
 * 724. Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/description/
 */
public class FindPivotIndex {

    /**
     * Runtime 1 ms Beats 98.05% of users with Java
     * Memory 45.32 MB Beats 63.52% of users with Java
     */
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 1; i < nums.length; i++) {
            rightSum = rightSum + nums[i];
        }

        if (rightSum == leftSum) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            leftSum = leftSum + nums[i - 1];
            rightSum = rightSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
