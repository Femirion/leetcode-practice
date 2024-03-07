package ru.femirion.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    /**
     * Runtime 60 ms Beats 20.56% of users with Java
     * Memory 69.12 MB Beats 30.36% of users with Java
     */
    public int findMinArrowShots1(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(x -> x[0]));

        int arrows = 0;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < end) {
                end = Math.min(end, points[i][1]);
            } else {
                end = points[i][1];
                arrows++;
            }
        }
        return arrows;
    }

    /**
     * Runtime 70 ms Beats 12.86% of users with Java
     * Memory 68.74 MB Beats 67.79% of users with Java
     */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(x -> x[0]));

        int arrows = 0;
        int end = points[0][1];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < points.length; i++) {
            if (stack.isEmpty()) {
                stack.push(points[i]);
                end = points[i][1];
                continue;
            }
            int[] top = stack.peek();
            if (points[i][0] <= top[1] && (points[i][0] <= end)) {
                end = Math.min(end, points[i][1]);
                stack.push(points[i]);
            } else {
                stack.clear();
                arrows++;
                end = points[i][1];
            }
        }

        if (!stack.isEmpty()) {
            arrows++;
        }

        return arrows;
    }
}
