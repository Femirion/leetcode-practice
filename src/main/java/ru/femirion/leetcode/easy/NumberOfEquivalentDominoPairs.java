package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1128. Number of Equivalent Domino Pairs
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/
 */
public class NumberOfEquivalentDominoPairs {

    /**
     * Runtime 10 ms Beats 62.19%
     * Memory 52.90 MB Beats 64.43%
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> dominos = new HashMap<>();

        for (int[] cur : dominoes) {
            int a = cur[0];
            int b = cur[1];

            int key = Math.max(a, b) * 10 + Math.min(a, b);
            dominos.put(key, dominos.getOrDefault(key, 0) + 1);
        }

        int result = 0;
        for (int count : dominos.values()) {
            if (count != 1) {
                result = result + (count * (count - 1) / 2);
            }
        }

        return result;
    }
}
