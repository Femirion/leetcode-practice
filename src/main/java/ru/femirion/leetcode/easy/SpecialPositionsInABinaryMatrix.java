package ru.femirion.leetcode.easy;

/**
 * 1582. Special Positions in a Binary Matrix
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/
 */
public class SpecialPositionsInABinaryMatrix {

    /**
     * Runtime 2 ms Beats 89.06% of users with Java
     * Memory 44.09 MB Beats 99.64% of users with Java
     */
    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] col = new int[mat[0].length];

        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    rows[i] = rows[i] + 1;
                    col[j] = col[j] + 1;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && col[j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }
}
