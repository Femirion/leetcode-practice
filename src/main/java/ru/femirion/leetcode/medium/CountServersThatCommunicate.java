package ru.femirion.leetcode.medium;

/**
 * 1267. Count Servers that Communicate
 * https://leetcode.com/problems/count-servers-that-communicate/description/
 */
public class CountServersThatCommunicate {

    /**
     * Runtime 2 ms Beats 100.00%
     * Memory 52.22 MB Beats 76.74%
     */
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                rows[i]++;
                cols[j]++;
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (1 < rows[i] || 1 < cols[j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
