package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 1389. Create Target Array in the Given Order
 * https://leetcode.com/problems/create-target-array-in-the-given-order/description/
 */
public class CreateTargetArrayInTheGivenOrder {

    /**
     * Runtime 4 ms Beats 8.14%
     * Memory 41.62 MB Beats 67.29%
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        int[][] numbers = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            numbers[i][0] = nums[i];
            numbers[i][1] = index[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (index[i] <= numbers[j][1]) {
                    numbers[j][1]++;
                }
            }
        }

        Arrays.sort(numbers, (a, b) -> a[1] - b[1]);

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int idx = numbers[i][1];
            result[idx] = numbers[i][0];
        }
        return result;
    }
}
