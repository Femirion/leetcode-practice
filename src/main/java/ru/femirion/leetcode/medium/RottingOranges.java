package ru.femirion.leetcode.medium;

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/description/
 */
public class RottingOranges {

    /**
     * Runtime 2 ms Beats 72.19%
     * Memory 42.34 MB Beats 50.89%
     */
    public int orangesRotting(int[][] grid) {
        int time =-1;
        boolean wasRotten = false;
        boolean hasFresh = false;

        do {
            wasRotten = false;
            hasFresh = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 4) {
                        grid[i][j] = 2;
                        continue;
                    }
                    if (grid[i][j] == 1) {
                        hasFresh = true;
                        continue;
                    }
                    if (grid[i][j] == 0) {
                        continue;
                    }
                    if (0 < i) {
                        if (grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 2;
                            wasRotten = true;
                        }
                    }
                    if (i < grid.length - 1) {
                        if (grid[i + 1][j] == 1) {
                            grid[i + 1][j] = 4;
                            wasRotten = true;
                        }
                    }
                    if (0 < j) {
                        if (grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 2;
                            wasRotten = true;
                        }
                    }
                    if (j < grid[i].length - 1) {
                        if (grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 4;
                            wasRotten = true;
                        }
                    }
                }
            }
            time++;
        } while (wasRotten);
        return hasFresh ? -1 : time;
    }
}
