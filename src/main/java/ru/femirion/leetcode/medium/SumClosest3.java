package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/description/
 */
public class SumClosest3 {

    /**
     * Runtime 15 ms Beats 46.87%
     * Memory 43.22 MB Beats 26.71%
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int nearestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left + 1 <= right) {
                int curElement = nums[i];
                int leftElement = nums[left];
                int rightElement = nums[right];
                int curSum = curElement + leftElement + rightElement;

                if (curSum == target) {
                    return target;
                }

                if (Math.abs(curSum - target) < Math.abs(nearestSum - target)) {
                    nearestSum = curSum;
                }

                if (curSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return nearestSum;
    }
}
