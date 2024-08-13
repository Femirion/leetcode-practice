package ru.femirion.leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 */
public class PascalsTriangleII {

    /**
     * Runtime 1 ms Beats 64.70%
     * Memory 41.06 MB Beats 44.52%
     */
    public List<Integer> getRow(int rowIndex) {
        int[] prev = new int[1];
        prev[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            int[] tmpArr = new int[i + 1];
            tmpArr[0] = 1;
            tmpArr[i] = 1;
            for (int j = 1; j < i; j++) {
                tmpArr[j] = prev[j] + prev[j - 1];
            }
            prev = tmpArr;
        }

        return Arrays.stream(prev).boxed().collect(Collectors.toList());
    }
}
