package ru.femirion.leetcode.easy;

/**
 * 1252. Cells with Odd Values in a Matrix
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 */
public class CellsWithOddValuesInAMatrix {

    /**
     * Runtime 2ms Beats 65.90% of users with Java
     * Memory 40.82MB Beats 15.98%of users with Java
     */
    public int oddCells(int m, int n, int[][] indices) {
        int[][] result = new int[m][n];
        for (int i = 0; i < indices.length; i++) {
            int line = indices[i][0];
            int column = indices[i][1];
            for (int a = 0; a < m; a++) {
                result[a][column] = result[a][column] + 1;
            }
            for (int b = 0; b < n; b++) {
                result[line][b] = result[line][b] + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
