package ru.femirion.leetcode.easy;

import java.util.*;

/**
 * 1200. Minimum Absolute Difference
 * https://leetcode.com/problems/minimum-absolute-difference/description/
 */
public class MinimumAbsoluteDifference {

    /**
     * Runtime 16 ms Beats 97.33% of users with Java
     * Memory 57.48 MB Beats 5.35% of users with Java
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff) {
                result.add(List.of(arr[i - 1], arr[i]));
                continue;
            }
            if (diff < minDiff) {
                result = new ArrayList<>();
                minDiff = diff;
                result.add(List.of(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
