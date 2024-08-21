package ru.femirion.leetcode.medium;

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 */
public class SearchA2DMatrix {

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.90 MB Beats 64.02%
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        int startIdx = 0;
        int endIdx = n;
        int midIdx = 0;;

        boolean foundInLine = false;
        while (startIdx <= endIdx) {
            midIdx = startIdx + ((endIdx - startIdx) / 2);
            if (matrix[midIdx][0] <= target && target <= matrix[midIdx][m]) {
                foundInLine = true;
                break;
            }
            if (target < matrix[midIdx][0]) {
                endIdx = midIdx - 1;
            }
            if (matrix[midIdx][m] < target) {
                startIdx = midIdx + 1;
            }
        }

        if (!foundInLine) {
            return false;
        }

        int curLine = midIdx;
        startIdx = 0;
        endIdx = m;
        while (startIdx <= endIdx) {
            midIdx = startIdx + ((endIdx - startIdx) / 2);
            if (matrix[curLine][midIdx] == target) {
                return true;
            }
            if (target < matrix[curLine][midIdx]) {
                endIdx = midIdx - 1;
            } else {
                startIdx = midIdx + 1;
            }
        }
        return false;
    }
}
