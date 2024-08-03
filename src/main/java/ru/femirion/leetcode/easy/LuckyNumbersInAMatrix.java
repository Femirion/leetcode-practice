package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1380. Lucky Numbers in a Matrix
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
 */
public class LuckyNumbersInAMatrix {

    /**
     * Runtime 3 ms Beats 61.54%
     * Memory 45.33 MB Beats 26.56%
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> minY = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int curMaxY = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                int cur = matrix[i][j];
                if (cur < curMaxY) {
                    curMaxY = cur;
                }
            }
            minY.add(curMaxY);
        }

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < matrix[0].length; j++) {
            int curMinX = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                int cur = matrix[i][j];
                if (curMinX < cur) {
                    curMinX = cur;
                }
            }
            if (minY.contains(curMinX)) {
                result.add(curMinX);
            }
        }

        return result;
    }
}
