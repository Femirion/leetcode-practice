package ru.femirion.leetcode.easy;

/**
 * 867. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/description/
 */
public class TransposeMatrix {

    /**
     * Runtime 1 ms Beats 33.28% of users with Java
     * Memory 44.73 MB Beats 57.04% of users with Java
     */
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
