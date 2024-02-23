package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Map;

/**
 * 1496. Path Crossing
 * https://leetcode.com/problems/path-crossing/description/
 */
public class PathCrossing {

    /**
     * Runtime 2 ms Beats 70.61% of users with Java
     * Memory 42.15 MB Beats 40.81% of users with Java
     */
    public boolean isPathCrossing(String path) {
        HashSet<Map.Entry<Integer, Integer>> points = new HashSet<>();

        int x = 0;
        int y = 0;
        Map.Entry<Integer, Integer> point = Map.entry(x, y);
        points.add(point);

        for (int i = 0; i < path.length(); i++) {
            char cur = path.charAt(i);
            switch (cur) {
                case 'N': {
                    y = y + 1;
                    break;
                }
                case 'S': {
                    y = y - 1;
                    break;
                }
                case 'E': {
                    x = x + 1;
                    break;
                }
                case 'W': {
                    x = x - 1;
                    break;
                }
            }

            point = Map.entry(x, y);

            if (points.contains(point)) {
                return true;
            } else {
                points.add(point);
            }
        }

        return false;
    }
}
