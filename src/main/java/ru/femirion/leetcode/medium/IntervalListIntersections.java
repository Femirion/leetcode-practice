package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. Interval List Intersections
 * https://leetcode.com/problems/interval-list-intersections/description/
 */
public class IntervalListIntersections {

    /**
     * Runtime 3 ms Beats 98.50%
     * Memory 45.13 MB Beats 89.68%
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        int p = 0;
        int q = 0;

        while (p < firstList.length && q < secondList.length) {
            int startF = firstList[p][0];
            int endF = firstList[p][1];

            int startS = secondList[q][0];
            int endS = secondList[q][1];

            if (endF < startS) {
                p++;
                continue;
            }

            if (endS < startF) {
                q++;
                continue;
            }

            int[] tmp = new int[2];
            tmp[0] = Math.max(startF, startS);
            tmp[1] = Math.min(endF, endS);
            result.add(tmp);

            if (endF < endS) {
                p++;
            } else {
                q++;
            }
        }


        return result.toArray(new int[result.size()][2]);
    }
}
