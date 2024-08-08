package ru.femirion.leetcode.medium;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {

    /**
     * Runtime 1 ms Beats 9.67%
     * Memory 40.28 MB Beats 56.17%
     */
    public int uniquePaths(int m, int n) {
        int[][] cachedResults = new int[m][n];

        cachedResults[m - 1][n - 1] = 1;

        if (n >= 2) {
            cachedResults[m - 1][n - 2] = 1;
        }

        if (m >= 2) {
            cachedResults[m - 2][n - 1] = 1;
        }

        for (int i = m - 1; 0 <= i; i--) {
            for (int j = n - 1; 0 <= j; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                var x1 = j == n - 1 ? 0 : cachedResults[i][j + 1];
                int x2 = i == m - 1 ? 0 : cachedResults[i + 1][j];
                cachedResults[i][j] = x1 + x2;
            }
        }

        return cachedResults[0][0];
    }
}
