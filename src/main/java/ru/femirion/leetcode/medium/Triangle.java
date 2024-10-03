package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/description/
 */
public class Triangle {

    /**
     * Runtime 9 ms Beats 9.79%
     * Memory 45.76 MB Beats 5.10%
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();

        List<Integer> zeroLevel = new ArrayList<>();
        zeroLevel.add(triangle.get(0).get(0));
        dp.add(zeroLevel);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> level = triangle.get(i);
            dp.add(new ArrayList<>());
            for (int j = 0; j < level.size(); j++) {
                int leftDp = (j == 0) ? 100000 : dp.get(i - 1).get(j - 1);
                int rightDp = (j == level.size() - 1) ? 100000 : dp.get(i - 1).get(j);
                int curValue = level.get(j);
                dp.get(i).add(Math.min(leftDp + curValue, rightDp + curValue));
            }
        }

        int min = Integer.MAX_VALUE;
        List<Integer> lastLevel = dp.get(dp.size() - 1);
        for (int i = 0; i < lastLevel.size(); i++) {
            if (lastLevel.get(i) < min) {
                min = lastLevel.get(i);
            }
        }
        return min;
    }
}
