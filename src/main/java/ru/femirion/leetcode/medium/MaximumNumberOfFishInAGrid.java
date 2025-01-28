package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 2658. Maximum Number of Fish in a Grid
 * https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/description/
 */
public class MaximumNumberOfFishInAGrid {

    /**
     * Runtime 6 ms Beats 34.17%
     * Memory 44.93 MB Beats 71.43%
     */
    public int findMaxFish(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int curResult = grid[i][j];
                grid[i][j] = 0;

                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i, j});

                while (!stack.isEmpty()) {
                    int[] elem = stack.pop();
                    curResult = curResult + grid[elem[0]][elem[1]];
                    grid[elem[0]][elem[1]] = 0;
                    if (0 < elem[0] && grid[elem[0] - 1][elem[1]] != 0) {
                        stack.push(new int[]{elem[0] - 1,elem[1]});
                    }
                    if (elem[0] < grid.length - 1 && grid[elem[0] + 1][elem[1]] != 0) {
                        stack.push(new int[]{elem[0] + 1, elem[1]});
                    }
                    if (0 < elem[1] && grid[elem[0]][elem[1] - 1] != 0) {
                        stack.push(new int[]{elem[0], elem[1] - 1});
                    }
                    if (elem[1] < grid[0].length - 1 && grid[elem[0]][elem[1] + 1] != 0) {
                        stack.push(new int[] {elem[0], elem[1] + 1});
                    }
                }

                result = Math.max(result, curResult);
            }
        }

        return result;
    }
}
