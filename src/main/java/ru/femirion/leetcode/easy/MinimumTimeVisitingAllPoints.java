package ru.femirion.leetcode.easy;

/**
 * 1266. Minimum Time Visiting All Points
 * https://leetcode.com/problems/minimum-time-visiting-all-points/description/
 */
public class MinimumTimeVisitingAllPoints {

    /**
     * Runtime 1 ms Beats 91.16% of users with Java
     * Memory 42.55 MB Beats 91.62% of users with Java
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        for (int i = 1; i < points.length; i++) {
            int prevX = points[i - 1][0];
            int prevY = points[i - 1][1];
            int curX = points[i][0];
            int curY = points[i][1];

            int diffX = Math.max(prevX, curX) - Math.min(prevX, curX);
            int diffY = Math.max(prevY, curY) - Math.min(prevY, curY);

            if (diffX < diffY) {
                result = result + diffX + (diffY - diffX);
            } else {
                result = result + diffY + (diffX - diffY);
            }
        }
        return result;
    }
}
