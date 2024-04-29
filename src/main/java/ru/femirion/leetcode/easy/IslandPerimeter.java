package ru.femirion.leetcode.easy;

/**
 * 463. Island Perimeter
 * https://leetcode.com/problems/island-perimeter/description/
 */
public class IslandPerimeter {

    /**
     * Runtime 5 ms Beats 42.26% of users with Java
     * Memory 45.17 MB Beats 92.61% of users with Java
     */
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = grid[i][j];
                if (cur == 0) {
                    continue;
                }

                boolean hasTopBorder = i == 0  ? false : grid[i - 1][j] != 0;
                boolean hasRightBorder = j == m - 1 ? false : grid[i][j + 1] != 0;
                boolean hasBottomBorder = i == n - 1 ? false : grid[i + 1][j] != 0;
                boolean hasLeftBorder = j == 0 ? false : grid[i][j - 1] != 0;

                if (hasTopBorder && hasRightBorder && hasBottomBorder && hasLeftBorder) {
                    continue;
                }

                int curPerimeter = 0;
                if (!hasTopBorder) {
                    curPerimeter++;
                }
                if (!hasRightBorder) {
                    curPerimeter++;
                }
                if (!hasBottomBorder) {
                    curPerimeter++;
                }
                if (!hasLeftBorder) {
                    curPerimeter++;
                }
                perimeter = perimeter + curPerimeter;
            }
        }
        return perimeter;
    }
}
