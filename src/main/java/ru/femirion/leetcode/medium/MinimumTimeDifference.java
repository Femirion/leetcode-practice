package ru.femirion.leetcode.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 539. Minimum Time Difference
 * https://leetcode.com/problems/minimum-time-difference/description/
 */
public class MinimumTimeDifference {

    /**
     * Runtime 5 ms Beats 67.28%
     * Memory 45.47 MB Beats 54.15%
     */
    public int findMinDifference2(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        for (int i = 0; i < times.length; i++) {
            String time = timePoints.get(i);
            times[i] = getHours(time) * 60 + getMinutes(time);
        }

        Arrays.sort(times);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < times.length; i++) {
            minDiff = Math.min(minDiff, times[i] - times[i - 1]);
        }

        int allDayMinutes = 24 * 60;
        minDiff = Math.min(minDiff, allDayMinutes - times[times.length - 1] + times[0]);

        return minDiff;
    }

    /**
     * Runtime 16 ms Beats 11.54%
     * Memory 46.22 MB Beats 20.41%
     */
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, (a, b) -> a.compareTo(b));

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < timePoints.size(); i++) {
            String t1 = timePoints.get(i - 1);
            String t2 = timePoints.get(i);

            int t1Minutes = getHours(t1) * 60 + getMinutes(t1);
            int t2Minutes = getHours(t2) * 60 + getMinutes(t2);
            minDiff = Math.min(minDiff, t2Minutes - t1Minutes);
        }

        int allDayMinutes = 24 * 60;
        String t2 = timePoints.get(timePoints.size() - 1);
        String t1 = timePoints.get(0);
        minDiff = Math.min(minDiff, allDayMinutes - (getHours(t2) * 60 + getMinutes(t2)) + (getHours(t1) * 60 + getMinutes(t1)));

        return minDiff;
    }

    private int getHours(String str) {
        return Integer.parseInt(str.substring(0, 2));
    }

    private int getMinutes(String str) {
        return Integer.parseInt(str.substring(3, 5));
    }
}
