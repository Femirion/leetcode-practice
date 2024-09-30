package ru.femirion.leetcode.medium;

/**
 * 2482. Difference Between Ones and Zeros in Row and Column
 * https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/description/
 */
public class DifferenceBetweenOnesAndZerosInRowAndColumn {

    /**
     * Runtime 7 ms Beats 64.98%
     * Memory 79.82 MB Beats 86.41%
     */
    public int[][] onesMinusZeros(int[][] grid) {
        int[] onesRowi = new int[grid.length];
        int[] onesColj = new int[grid[0].length];
        int[] zerosRowi = new int[grid.length];
        int[] zerosColj = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    zerosRowi[i]++;
                    zerosColj[j]++;
                } else {
                    onesRowi[i]++;
                    onesColj[j]++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = onesRowi[i] + onesColj[j] - zerosRowi[i] - zerosColj[j];
            }
        }
        return grid;
    }
}
