package ru.femirion.leetcode.medium;

/**
 * 1605. Find Valid Matrix Given Row and Column Sums
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description/
 */
public class FindValidMatrixGivenRowAndColumnSums {

    /**
     * Runtime 6 ms Beats 51.47%
     * Memory 53.01 MB Beats 34.29%
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] result = new int[rowSum.length][colSum.length];

        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                if (colSum[j] <= rowSum[i]) {
                    result[i][j] = colSum[j];
                    rowSum[i] = rowSum[i] - colSum[j];
                    colSum[j] = 0;
                } else {
                    result[i][j] = rowSum[i];
                    rowSum[i] = 0;
                    colSum[j] = colSum[j] - result[i][j];
                }
            }
        }

        return result;
    }
}
