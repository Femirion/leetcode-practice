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

    /**
     * Runtime 9 ms Beats 60.93% of users with Java
     * Memory 46.71 MB Beats 18.19% of users with Java
     */
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        List<Interval> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        if (intervals.length == 1) {
            list.add(new Interval(start, end));
        }

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new Interval(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if (i == intervals.length - 1) {
                list.add(new Interval(start, end));
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Interval interval = list.get(i);
            result[i][0] = interval.start;
            result[i][1] = interval.end;
        }
        return result;
    }

    /**
     * Runtime 7 ms Beats 97.24%
     * Memory 46.34 MB Beats 63.31%
     */
    public int[][] merge3(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int prevBegin = intervals[0][0];
        int prevEnd = intervals[0][1];
        int curBegin = 0;
        int curEnd = 0;

        List<int[]> result = new ArrayList<>();
        boolean wasAdded = true;
        for (int i = 1; i <= intervals.length; i++) {
            curBegin = i == intervals.length ? Integer.MAX_VALUE : intervals[i][0];
            curEnd = i == intervals.length ? Integer.MAX_VALUE : intervals[i][1];

            if (curBegin <= prevEnd) {
                prevBegin = Math.min(prevBegin, curBegin);
                prevEnd = Math.max(prevEnd, curEnd);
            } else {
                int[] tmp = new int[2];
                tmp[0] = prevBegin;
                tmp[1] = prevEnd;
                result.add(tmp);
                prevBegin = curBegin;
                prevEnd = Math.max(prevEnd, curEnd);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

    private static class Interval {
        private final int start;
        private final int end;

        private Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
