package ru.femirion.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1122. Relative Sort Array
 * https://leetcode.com/problems/relative-sort-array/
 */
public class RelativeSortArray {

    /**
     * Runtime 4ms Beats 23.13% of users with Java
     * Memory 41.56MB Beats 14.75% of users with Java
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        int[] result = new int[arr1.length];
        int p = 0;
        for (int i = 0; i < arr2.length; i++) {
            int count = map.get(arr2[i]);
            for (int j = 0; j < count; j++) {
                result[p] = arr2[i];
                p++;
            }
            map.remove(arr2[i]);
        }
        List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .collect(Collectors.toList());

        for (Map.Entry<Integer, Integer> e : entries) {
            int count = e.getValue();
            for (int j = 0; j < count; j++) {
                result[p] = e.getKey();
                p++;
            }
        }
        return result;
    }

}
