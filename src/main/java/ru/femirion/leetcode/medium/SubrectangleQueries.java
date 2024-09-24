package ru.femirion.leetcode.medium;

/**
 * 1476. Subrectangle Queries
 * https://leetcode.com/problems/subrectangle-queries/description/
 */
public class SubrectangleQueries {

    private int[][] arr;

    /**
     * Runtime 21 ms Beats 79.80%
     * Memory 48.11 MB Beats 8.31%
     */
    public SubrectangleQueries(int[][] rectangle) {
        arr = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                arr[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return arr[row][col];
    }
}
