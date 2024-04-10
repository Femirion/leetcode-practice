package ru.femirion.leetcode.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1086. High Five
 * https://leetcode.com/problems/high-five/description/
 */
public class HighFive {

    /**
     * Runtime 3 ms Beats 98.25% of users with Java
     * Memory 44.96 MB Beats 21.46% of users with Java
     */
    public int[][] highFive1(int[][] items) {
        int[] maxElements = new int[5005];
        Arrays.fill(maxElements, -1);
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            int e = items[i][0];
            int val = items[i][1];

            int offset = e * 5;
            int min = maxElements[offset];
            if (min == -1) {
                count++;
            }
            int minIds = offset;
            for (int j = offset; j < offset + 5; j++) {
                if (maxElements[j] == -1) {
                    minIds = j;
                    min = maxElements[j];
                    break;
                }
                if (maxElements[j] <= min) {
                    minIds = j;
                    min = maxElements[j];
                }
            }
            if (min < val) {
                maxElements[minIds] = val;
            }
        }

        int[][] result = new int[count][2];
        int idx = 0;
        int tmpSum = 0;
        for (int i = 0; i < maxElements.length; i++) {
            if (maxElements[i] == -1 && tmpSum == 0) {
                continue;
            }
            tmpSum = tmpSum + maxElements[i];
            if ((i - 4) % 5 == 0) {
                if (tmpSum != 0) {
                    result[idx][0] = (i - 4) / 5;
                    result[idx][1] = tmpSum / 5;
                    idx++;
                    tmpSum = 0;
                }
            }
        }
        return result;
    }

    /**
     * Runtime 6 ms Beats 37.52% of users with Java
     * Memory 45.13 MB Beats 5.09% of users with Java
     */
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, int[]> maxMap = new TreeMap<>();

        for (int i = 0; i < items.length; i++) {
            int e = items[i][0];
            int val = items[i][1];

            int[] values = maxMap.getOrDefault(e, new int[5]);
            int min = values[0];
            int minIds = 0;
            for (int j = 0; j < 5; j++) {
                if (values[j] == 0) {
                    minIds = j;
                    min = values[j];
                    break;
                }
                if (values[j] <= min) {
                    minIds = j;
                    min = values[j];
                }
            }
            if (min < val) {
                values[minIds] = val;
                maxMap.put(e, values);
            }
        }

        int i = 0;
        int[][] result = new int[maxMap.size()][2];
        for (Map.Entry<Integer, int[]> e : maxMap.entrySet()) {
            result[i][0] = e.getKey();
            result[i][1] = Arrays.stream(e.getValue()).sum() / 5;
            i++;
        }
        return result;
    }
}
