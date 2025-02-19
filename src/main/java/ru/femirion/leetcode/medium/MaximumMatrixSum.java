package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1975. Maximum Matrix Sum
 * https://leetcode.com/problems/maximum-matrix-sum/description/
 */
public class MaximumMatrixSum {

    /**
     * Runtime 49 ms Beats 5.65%
     * Memory 57.61 MB Beats 7.62%
     */
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;

        List<Integer> negativeNums = new ArrayList<>();

        long sum = 0;
        int min = Integer.MAX_VALUE;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curVal = matrix[i][j];
                sum = sum + curVal;
                if (0 < curVal) {
                    min = Math.min(curVal, min);
                    continue;
                }
                if (curVal == 0) {
                    hasZero = true;
                    continue;
                }
                negativeNums.add(curVal);
            }
        }

        if (negativeNums.isEmpty()) {
            return sum;
        }

        Collections.sort(negativeNums);

        int end = negativeNums.size();
        if (negativeNums.size() % 2 != 0) {
            if (hasZero) {
                negativeNums.add(0);
                end++;
            } else {
                if (min < Math.abs(negativeNums.get(negativeNums.size() - 1))) {
                    int maxNegative = negativeNums.get(0);
                    sum = sum + (-maxNegative) * 2 - min * 2;
                    negativeNums.remove(0);
                    negativeNums.add(-min);
                }
                end--;
            }
        }

        if (negativeNums.size() == 1) {
            return sum;
        }

        for (int i = 0; i < end; i = i + 2) {
            int first = negativeNums.get(i);
            int second = negativeNums.get(i + 1);

            sum = sum + (-first) * 2 + (-second) * 2;
        }

        return sum;
    }
}
