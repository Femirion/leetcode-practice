package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/description/
 */
public class SpiralMatrix {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.42 MB Beats 47.62%
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int leftSide = 0;
        int rightSide = matrix[0].length - 1;
        int topSide = 0;
        int bottomSide = matrix.length - 1;

        boolean canMove = true;

        List<Integer> result = new ArrayList<>();



        while (canMove) {
            canMove = false;
            for (int i = leftSide; i <= rightSide; i++) {
                result.add(matrix[topSide][i]);
            }
            topSide++;
            canMove = false;
            for (int i = topSide; i <= bottomSide; i++) {
                result.add(matrix[i][rightSide]);
                canMove = true;
            }
            if (!canMove) {
                break;
            }
            rightSide--;
            canMove = false;
            for (int i = rightSide; leftSide <= i; i--) {
                result.add(matrix[bottomSide][i]);
                canMove = true;
            }
            if (!canMove) {
                break;
            }
            if (matrix[0].length == 1) {
                break;
            }
            bottomSide--;
            canMove = false;
            for (int i = bottomSide; topSide <= i; i--) {
                result.add(matrix[i][leftSide]);
                canMove = true;
            }
            leftSide++;
            if (!canMove) {
                break;
            }
            if (rightSide < leftSide) {
                break;
            }
        }
        return result;
    }

}
