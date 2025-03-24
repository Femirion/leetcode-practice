package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 3169. Count Days Without Meetings
 * https://leetcode.com/problems/count-days-without-meetings/description/
 */
public class CountDaysWithoutMeetings {

    /**
     * Runtime 37 ms Beats 78.45%
     * Memory 100.48 MB Beats 55.56%
     */
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (x, y) -> x[0] - y[0]);

        int prevStart = 0;
        int prevEnd = 0;

        int limit = Math.max(days, meetings.length);

        for (int i = 0; i < limit; i++) {
            if (meetings.length <= i) {
                break;
            }
            int curStart = meetings[i][0];
            if (curStart <= prevEnd) {
                if (prevEnd < meetings[i][1]) {
                    days = days - (meetings[i][1] - prevEnd);
                    prevEnd = meetings[i][1];
                }
            } else {
                prevStart = curStart;
                prevEnd = meetings[i][1];
                days = days - (meetings[i][1] - curStart) - 1;
            }
        }

        return 0 < days ? days : 0;
    }
}
