package ru.femirion.leetcode.easy;

/**
 * 1779. Find Nearest Point That Has the Same X or Y Coordinate
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/description/
 */
public class FindNearestPointThatHasTheSameXOrYCoordinate {

    /**
     * Runtime 2 ms Beats 100.00% of users with Java
     * Memory 49.25 MB Beats 62.95% of users with Java
     */
    public int nearestValidPoint(int x, int y, int[][] points) {
        int result = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            int curX = points[i][0];
            int curY = points[i][1];

            if (curX == x || curY == y) {
                int distance = Math.abs(x - curX) + Math.abs(y - curY);

                if (distance == result) {
                    if (i < minIdx) {
                        result = distance;
                        minIdx = i;
                    }
                }

                if (distance < result) {
                    result = distance;
                    minIdx = i;
                }
            }
        }


        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        return minIdx;
    }
}
