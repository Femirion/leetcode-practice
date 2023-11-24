package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 2357. Make Array Zero by Subtracting Equal Amounts
 * https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/
 */
public class MakeArrayZeroBySubtractingEqualAmounts {

    /**
     * Runtime 1ms Beats 64.20% of users with Java
     * Memory 40.10MB Beats 50.82% of users with Java
     */
    public int minimumOperations(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 0 ? 0 : 1;
        }
        Arrays.sort(nums);
        int prev = nums[0];
        int count = 0;
        int all = 0;
        if (prev != 0) {
            count++;
            all = prev;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - all != 0) {
                int div = (prev - all) == 0 ? 1 : (nums[i] - all)/prev;
                count = count + div;
                all = all + (nums[i] - all);
                prev = nums[i];
                nums[i] = nums[i] - all;
            }
        }
        return count;
    }

}
