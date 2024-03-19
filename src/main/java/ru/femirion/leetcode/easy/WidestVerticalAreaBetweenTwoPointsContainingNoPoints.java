package ru.femirion.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1637. Widest Vertical Area Between Two Points Containing No Points
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/description/
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    /**
     * Runtime 45 ms Beats 9.27% of users with Java
     * Memory 71.62 MB Beats 96.41% of users with Java
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < points.length; i++) {
            int prev = points[i - 1][0];
            int cur = points[i][0];
            int distance = Math.abs(prev - cur);
            if (distance > max) {
                max = distance;
            }
        }
        return max;
    }
}
