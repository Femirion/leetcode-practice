package ru.femirion.leetcode.medium;

/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class SetMatrixZeroes {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 46.00 MB Beats 5.27%
     */
    public void setZeroes(int[][] matrix) {
        int[] zeroRows = new int[matrix.length];
        int[] zeroCols = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = 1;
                    zeroCols[j] = 1;
                }
            }
        }

        for (int i = 0; i < zeroRows.length; i++) {
            if (zeroRows[i] == 1) {
                for (int j = 0; j < zeroCols.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < zeroCols.length; i++) {
            if (zeroCols[i] == 1) {
                for (int j = 0; j < zeroRows.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
