package ru.femirion.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 356. Line Reflection
 * https://leetcode.com/problems/line-reflection/description/
 */
public class LineReflection {

    public boolean isReflected(int[][] points) {
        Set<Map.Entry<Integer, Integer>> uniquePoints = new HashSet<>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        for (int[] point : points) {
            uniquePoints.add(Map.entry(point[0], point[1]));

            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
        }
        int doubleMiddle = maxX + minX;

        for (Map.Entry<Integer, Integer> point : uniquePoints) {
            int x = point.getKey(), y = point.getValue();
            int reflectedX = doubleMiddle - x;

            if (!uniquePoints.contains(Map.entry(reflectedX, y))) {
                return false;
            }
        }

        return true;
    }
}
