package ru.femirion.leetcode.medium;

import java.util.Arrays;

/**
 * 1329. Sort the Matrix Diagonally
 * https://leetcode.com/problems/sort-the-matrix-diagonally/description/
 */
public class SortTheMatrixDiagonally {

    /**
     * Runtime 5 ms Beats 77.72%
     * Memory 45.02 MB Beats 29.81%
     */
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (m == 1) {
            return mat;
        }

        int max = Math.max(m, n);

        for (int i = 0 - max + 1; i < max; i++) {
            int idx = i;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                if (0 <= idx && idx < m) {
                    arr[j] = mat[j][idx];
                } else {
                    arr[j] = 101;
                }
                idx++;
            }
            Arrays.sort(arr);
            idx = i;
            int elemIdx = 0;
            for (int j = 0; j < n; j++) {
                if (0 <= idx && idx < m) {
                    mat[j][idx] = arr[elemIdx];
                    elemIdx++;
                }
                idx++;
                if (m == idx) {
                    break;
                }
            }
        }

        return mat;
    }
}
