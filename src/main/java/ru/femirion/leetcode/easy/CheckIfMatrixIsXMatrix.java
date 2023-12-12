package ru.femirion.leetcode.easy;


/**
 * 2319. Check if Matrix Is X-Matrix
 * https://leetcode.com/problems/check-if-matrix-is-x-matrix/
 */
public class CheckIfMatrixIsXMatrix {

    /**
     * Runtime 3ms Beats 22.95% of users with Java
     * Memory 44.72MB Beats 24.21% of users with Java
     */
    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == j) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                    continue;
                }
                if (grid[i].length - 1 - i == j) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                    continue;
                }
                if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
