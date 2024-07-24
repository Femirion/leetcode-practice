package ru.femirion.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberOfIslands {

    /**
     * Runtime 863 ms Beats 5.13%
     * Memory 61.71 MB Beats 5.60%
     */
    public int numIslands(char[][] grid) {
        Set<Map.Entry<Integer, Integer>> lands = new HashSet<>();
        Set<Map.Entry<Integer, Integer>> water = new HashSet<>();

        int result = 0;
        LinkedList<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Map.Entry<Integer, Integer> tmp = Map.entry(i, j);
                if (lands.contains(tmp) || water.contains(tmp)) {
                    continue;
                }

                if (grid[i][j] == '0') {
                    water.add(tmp);
                    continue;
                }

                queue.addFirst(tmp);

                while(!queue.isEmpty()) {
                    Map.Entry<Integer, Integer> cur = queue.removeFirst();
                    if (lands.contains(cur) || water.contains(cur)) {
                        continue;
                    }
                    lands.add(cur);
                    if (cur.getKey() != 0) {
                        Map.Entry<Integer, Integer> top = Map.entry(cur.getKey() - 1, cur.getValue());
                        if(grid[cur.getKey() - 1][cur.getValue()] == '1') {
                            if (!lands.contains(top)) {
                                queue.addLast(top);
                            }
                        } else {
                            water.add(top);
                        }
                    }
                    if (cur.getKey() != grid.length - 1) {
                        Map.Entry<Integer, Integer> bottom = Map.entry(cur.getKey() + 1, cur.getValue());
                        if(grid[cur.getKey() + 1][cur.getValue()] == '1') {
                            if (!lands.contains(bottom)) {
                                queue.addLast(bottom);
                            }
                        } else {
                            water.add(bottom);
                        }
                    }
                    if (cur.getValue() != 0) {
                        Map.Entry<Integer, Integer> left = Map.entry(cur.getKey(), cur.getValue() - 1);
                        if(grid[cur.getKey()][cur.getValue() - 1] == '1') {
                            if (!lands.contains(left)) {
                                queue.addLast(left);
                            }
                        } else {
                            water.add(left);
                        }
                    }
                    if (cur.getValue() != grid[i].length - 1) {
                        Map.Entry<Integer, Integer> right = Map.entry(cur.getKey(), cur.getValue() + 1);
                        if(grid[cur.getKey()][cur.getValue() + 1] == '1') {
                            if (!lands.contains(right)) {
                                queue.addLast(right);
                            }
                        } else {
                            water.add(right);
                        }
                    }
                }

                result++;
            }
        }

        return result;
    }
}
