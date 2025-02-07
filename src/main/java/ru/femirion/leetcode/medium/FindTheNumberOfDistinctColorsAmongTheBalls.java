package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 3160. Find the Number of Distinct Colors Among the Balls
 * https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/
 */
public class FindTheNumberOfDistinctColorsAmongTheBalls {

    /**
     * Runtime 44 ms Beats 40.77%
     * Memory 97.05 MB Beats 68.67%
     */
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colors = new HashMap<>();
        Map<Integer, Integer> balls = new HashMap<>();

        int[] result = new int[queries.length];
        int idx = 0;

        int colorCount = 0;

        for (int[] q : queries) {
            int ball = q[0];
            int newColor = q[1];

            int existedCollor = balls.getOrDefault(ball, 0);
            int newColorCount = colors.getOrDefault(newColor, 0);

            if (existedCollor == 0 && newColorCount == 0) {
                colors.put(newColor,  1);
                balls.put(ball, newColor);
                colorCount++;
            } else {
                int oldColor = balls.getOrDefault(ball, 0);
                balls.put(ball, newColor);

                if (oldColor != newColor) {
                    int oldColorCount = colors.getOrDefault(oldColor, -1);
                    oldColorCount--;

                    if (oldColorCount == 0) {
                        colorCount--;
                    }
                    if (oldColorCount < 0) {
                        oldColorCount = 0;
                    }

                    colors.put(oldColor, oldColorCount);
                    colors.put(newColor, newColorCount + 1);
                    if (newColorCount == 0) {
                        colorCount++;
                    }
                }
            }
            result[idx] = colorCount;
            idx++;
        }

        return result;
    }
}
