package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/description/
 */
public class InsertInterval {

    /**
     * Runtime 2 ms Beats 37.10%
     * Memory 44.92 MB Beats 23.72%
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if (intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[result.size()][]);
        }

        int i = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else {
                break;
            }
        }

        if (i == intervals.length) {
            result.add(newInterval);
            return result.toArray(new int[result.size()][]);
        }

        int[] tmp = new int[2];
        tmp[0] = Math.min(intervals[i][0], newInterval[0]);
        tmp[1] = newInterval[1];

        for (; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                break;
            }
            tmp[0] = Math.min(intervals[i][0], Math.min(tmp[0], newInterval[0]));
            tmp[1] = Math.max(intervals[i][1], Math.max(tmp[1], newInterval[1]));
        }

        result.add(tmp);

        for (; i < intervals.length; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
