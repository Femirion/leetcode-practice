package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 */
public class ShortestUnsortedContinuousSubarray {

    /**
     * Runtime 21 ms Beats 5.73%
     * Memory 45.42 MB Beats 29.51%
     */
    public int findUnsortedSubarray(int[] nums) {
        int[][] positions = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            positions[i][0] = i;
            positions[i][1] = nums[i];
        }

        Arrays.sort(positions, (x, y) -> x[1] - y[1]);

        int start = -1;
        int end = -1;
        for (int i = 0; i < positions.length; i++) {
            if (positions[i][0] != i) {
                if (start == - 1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }
        return start == -1 && end == -1 ? 0 : end - start + 1;
    }
}
