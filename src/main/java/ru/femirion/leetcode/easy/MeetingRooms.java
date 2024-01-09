package ru.femirion.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 252. Meeting Rooms
 * https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRooms {

    /**
     * Runtime 617ms Beats 5.07% of users with Java
     * Memory 83.77MB Beats 6.71% of users with Java
     */
    public boolean canAttendMeetings(int[][] intervals) {
        int[] arr = new int[10000001];
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = start; j < end; j++) {
                if (arr[j] != 0) {
                    return false;
                } else {
                    arr[j] = arr[j] + 1;
                }
            }
        }
        return true;
    }

    /**
     * Runtime 7ms Beats 34.30%of users with Java
     * Memory 46.04MB Beats 13.60%of users with Java
     */
    public boolean canAttendMeetings1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Runtime 3ms Beats 99.83%of users with Java
     * Memory 46.70MB Beats 6.71% of users with Java
     */
    public boolean canAttendMeetings2(int[][] intervals) {
        if (intervals.length == 1) {
            return true;
        }
        int[] begins = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(begins);
        Arrays.sort(ends);

        for (int i = 1; i < intervals.length; i++) {
            if (ends[i] < begins[i - 1]) {
                return false;
            }
        }

        return true;
    }

}
