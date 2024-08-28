package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1905. Count Sub Islands
 * https://leetcode.com/problems/count-sub-islands/description/
 */
public class CountSubIslands {

    /**
     * Runtime 22 ms Beats 56.06%
     * Memory 93.58 MB Beats 5.03%
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        List<Point> island = new ArrayList<>();

        int result = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    island.add(new Point(i, j));
                    grid2[i][j] = 0;
                    dfs(i, j, grid2, island);
                    boolean isIsland = true;
                    for (Point p : island) {
                        if (grid1[p.x][p.y] != 1) {
                            isIsland = false;
                            break;
                        }
                    }
                    if (isIsland) {
                        result++;
                    }
                    island.clear();
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, int[][] grid2, List<Point> island) {
        if (0 <= i - 1) {
            if (grid2[i - 1][j] == 1) {
                island.add(new Point(i - 1, j));
                grid2[i - 1][j] = 0;
                dfs(i - 1, j, grid2, island);
            }
        }
        if (0 <= j - 1) {
            if (grid2[i][j - 1] == 1) {
                island.add(new Point(i, j - 1));
                grid2[i][j - 1] = 0;
                dfs(i, j - 1, grid2, island);
            }
        }
        if (i + 1 < grid2.length) {
            if (grid2[i + 1][j] == 1) {
                island.add(new Point(i + 1, j));
                grid2[i + 1][j] = 0;
                dfs(i + 1, j, grid2, island);
            }
        }
        if (j + 1 < grid2[i].length) {
            if (grid2[i][j + 1] == 1) {
                island.add(new Point(i, j + 1));
                grid2[i][j + 1] = 0;
                dfs(i, j + 1, grid2, island);
            }
        }
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "x=" + x + " y=" + y + ";";
        }
    }
}
