package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * 1356. Sort Integers by The Number of 1 Bits
 */
public class SortIntegersByTheNumberOf1Bits {

    /**
     * Runtime 11 ms Beats 41.72% of users with Java
     * Memory 44.44 MB Beats 82.30% of users with Java
     */
    public int[] sortByBits(int[] arr) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        int countBits = 0;
        for (int i = 0; i < arr.length; i++) {
            countBits = Integer.bitCount(arr[i]);
            List<Integer> list = map.getOrDefault(countBits, new ArrayList<>());
            list.add(arr[i]);
            map.put(countBits, list);
        }

        int[] result = new int[arr.length];
        int i = 0;
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
            for (int e : list) {
                result[i] = e;
                i++;
            }
        }
        return result;
    }
}
