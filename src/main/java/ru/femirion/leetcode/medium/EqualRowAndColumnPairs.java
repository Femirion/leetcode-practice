package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 2352. Equal Row and Column Pairs
 * https://leetcode.com/problems/equal-row-and-column-pairs/description/
 */
public class EqualRowAndColumnPairs {

    /**
     * Runtime 18 ms Beats 89.42% of users with Java
     * Memory 50.28 MB Beats 61.45% of users with Java
     */
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                list.add(grid[i][j]);
            }
            rowMap.put(list, rowMap.getOrDefault(list, 0) + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                list.add(grid[j][i]);
            }
            int val = rowMap.getOrDefault(list, 0);
            count = count + val;
        }

        return count;
    }
}
