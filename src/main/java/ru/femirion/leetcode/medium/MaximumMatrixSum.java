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
     * Runtime 6 ms Beats 85.54%
     * Memory 55.06 MB Beats 68.33%
     */
    public long maxMatrixSum2(int[][] matrix) {
        int n = matrix.length;

        long positiveSum = 0;
        long sum = 0;
        int negativeCount = 0;
        boolean hasZero = false;
        int minPositive = Integer.MAX_VALUE;
        int maxNegative = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curVal = matrix[i][j];

                positiveSum = positiveSum + Math.abs(curVal);

                if (0 < curVal) {
                    minPositive = Math.min(curVal, minPositive);
                    sum = sum + curVal;
                    continue;
                }

                if (curVal == 0) {
                    hasZero = true;
                    continue;
                }

                negativeCount++;

                if (maxNegative < curVal) {
                    if (maxNegative == Integer.MIN_VALUE) {
                        maxNegative = 0;
                    }
                    sum = sum + (-maxNegative * 2) + curVal;
                    maxNegative = curVal;
                } else {
                    sum = sum - curVal;
                }
            }
        }

        if (negativeCount == 0 || negativeCount % 2 == 0 || hasZero) {
            return positiveSum;
        }

        if (minPositive < Math.abs(maxNegative)) {
            return sum + (-maxNegative * 2) - minPositive * 2;
        } else {
            return sum;
        }
    }


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
