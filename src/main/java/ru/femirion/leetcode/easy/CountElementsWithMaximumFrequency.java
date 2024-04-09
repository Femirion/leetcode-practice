package ru.femirion.leetcode.easy;

import java.util.*;

/**
 * 3005. Count Elements With Maximum Frequency
 * https://leetcode.com/problems/count-elements-with-maximum-frequency/description/
 */
public class CountElementsWithMaximumFrequency {

    /**
     * Runtime 9 ms Beats 6.24% of users with Java
     * Memory 44.04 MB Beats 7.38% of users with Java
     */
    public int maxFrequencyElements(int[] nums) {
        int[][] arr = new int[101][2];

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            arr[cur][0] = i;
            arr[cur][1]++;
        }

        Arrays.sort(arr, Comparator.comparingInt(x -> x[1]));
        int result = arr[100][1];
        int i = 99;
        while (arr[i][1] == arr[100][1]) {
            result = result + arr[i][1];
            i--;
        }
        return result;
    }
}
