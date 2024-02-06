package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {
    /**
     * Runtime 12  ms Beats 19.35% of users with Java
     * Memory 46.56 MB Beats 38.25% of users with Java
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        if (intervals.length == 1) {
            list.add(Map.entry(start, end));
        }

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(Map.entry(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if (i == intervals.length - 1) {
                list.add(Map.entry(start, end));
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
        }
        return result;
    }
}
