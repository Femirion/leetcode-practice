package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 */
public class SortCharactersByFrequency {

    /**
     * Runtime 19 ms Beats 40.12% of users with Java
     * Memory 45.36 MB Beats 62.79% of users with Java
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = map.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
