package ru.femirion.leetcode.easy;

/**
 * 1572. Matrix Diagonal Sum
 * https://leetcode.com/problems/matrix-diagonal-sum/description/
 */
public class MatrixDiagonalSum {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 44.30 MB Beats 25.65%t
     */
    public int diagonalSum(int[][] mat) {
        if (mat.length == 1) {
            return mat[0][0];
        }
        int sum = 0;
        int primaryDiagonalIdx = 0;
        int secondaryDiagonalIdx = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            if (primaryDiagonalIdx != secondaryDiagonalIdx) {
                sum = sum + mat[i][primaryDiagonalIdx] + mat[i][secondaryDiagonalIdx];
            } else {
                sum = sum + mat[i][primaryDiagonalIdx];
            }
            primaryDiagonalIdx++;
            secondaryDiagonalIdx--;
        }

        return sum;
    }
}
