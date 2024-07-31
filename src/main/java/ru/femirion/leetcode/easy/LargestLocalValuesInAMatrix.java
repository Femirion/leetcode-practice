package ru.femirion.leetcode.easy;

/**
 * 2373. Largest Local Values in a Matrix
 * https://leetcode.com/problems/largest-local-values-in-a-matrix/description/
 */
public class LargestLocalValuesInAMatrix {

    /**
     * Runtime 3 ms Beats 51.89%
     * Memory 45.72 MB Beats 10.38%
     */
    public int[][] largestLocal(int[][] grid) {
        int m = grid.length - 2;
        int[][] result = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int max = Integer.MIN_VALUE;
                for (int p = i; p < i + 3; p++) {
                    for (int k = j; k < j + 3; k++) {

                        if (max < grid[p][k]) {
                            max = grid[p][k];
                        }
                    }
                }
                result[i][j] = max;
            }
        }
        return result;
    }
}
