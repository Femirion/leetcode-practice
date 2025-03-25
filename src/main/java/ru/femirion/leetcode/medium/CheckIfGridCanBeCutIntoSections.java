package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 3394. Check if Grid can be Cut into Sections
 * https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/
 * Runtime 99 ms Beats 59.29%
 * Memory 122.50 MB Beats 51.33%
 */
public class CheckIfGridCanBeCutIntoSections {

    public boolean checkValidCuts(int n, int[][] rectangles) {
        int size = rectangles.length;
        int[][] sectionsX = new int[size][2];
        int[][] sectionsY = new int[size][2];

        for (int i = 0; i < size; i++) {
            sectionsX[i][0] = rectangles[i][0];
            sectionsX[i][1] = rectangles[i][2];
            sectionsY[i][0] = rectangles[i][1];
            sectionsY[i][1] = rectangles[i][3];
        }

        return canBeCutted(sectionsX) || canBeCutted(sectionsY);
    }

    private boolean canBeCutted(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        int count = 0;
        int maxEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (maxEnd <= intervals[i][0]) {
                count++;
            }
            maxEnd = Math.max(maxEnd, intervals[i][1]);
            if (count == 2) {
                return true;
            }
        }
        return false;
    }
}
