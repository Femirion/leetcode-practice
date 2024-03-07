package ru.femirion.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 */
public class NonOverlappingIntervals {

    /**
     * Runtime 51 ms Beats 39.08% of users with Java
     * Memory 72.89 MB Beats 97.76% of users with Java
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));

        int prev = 0;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return intervals.length - count;
    }


}
