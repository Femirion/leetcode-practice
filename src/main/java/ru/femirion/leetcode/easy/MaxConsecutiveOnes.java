package ru.femirion.leetcode.easy;

/**
 * 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {

    /**
     * Runtime 2ms Beats 83.90 %of users with Java
     * Memory 44.84MB Beats 13.22% of users with Java
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int maxConsecutiveOnes = 0;
        boolean isConsecutiveOnes = false;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current == 1) {
                isConsecutiveOnes = true;
                result++;
                if (result > maxConsecutiveOnes) {
                    maxConsecutiveOnes = result;
                }
            } else {
                isConsecutiveOnes = false;
                result = 0;
            }
        }
        return maxConsecutiveOnes;
    }

}
