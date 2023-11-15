package ru.femirion.leetcode.easy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2363. Merge Similar Items
 * https://leetcode.com/problems/merge-similar-items/
 */
public class MergeSimilarItems {

    /**
     * Runtime 14ms Beats 5.94% of users with Java
     * Memory 45.18MB Beats 6.93% of users with Java
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> items1Map = new HashMap<>();
        Map<Integer, Integer> items2Map = new HashMap<>();

        for (int i = 0; i < items1.length; i++) {
            items1Map.put(items1[i][0], items1[i][1]);
        }

        for (int i = 0; i < items2.length; i++) {
            items2Map.put(items2[i][0], items2[i][1]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < items2.length; i++) {
            int currentValue = items2[i][0];
            Integer item1Weigh = items1Map.get(currentValue);
            if (item1Weigh != null) {
                result.add(createResultList(currentValue, item1Weigh + items2[i][1]));
            } else {
                result.add(createResultList(currentValue, items2[i][1]));
            }
        }

        for (int i = 0; i < items1.length; i++) {
            int currentValue = items1[i][0];
            Integer item2Weigh = items2Map.get(currentValue);
            if (item2Weigh == null) {
                result.add(createResultList(currentValue, items1[i][1]));
            }
        }

        return result.stream()
                .sorted(Comparator.comparingInt(e -> e.get(0)))
                .collect(Collectors.toList());
    }

    /**
     * Runtime 11ms Beats 26.40% of users with Java
     * Memory 44.70MB Beats 21.78% of users with Java
     */
    public List<List<Integer>> mergeSimilarItems1(int[][] items1, int[][] items2) {
        Map<Integer, Integer> itemsMap = new HashMap<>();

        for (int i = 0; i < items1.length; i++) {
            int value = items1[i][0];
            int weight = items1[i][1];
            itemsMap.put(value, itemsMap.getOrDefault(value, 0) + weight);
        }

        for (int i = 0; i < items2.length; i++) {
            int value = items2[i][0];
            int weight = items2[i][1];
            itemsMap.put(value, itemsMap.getOrDefault(value, 0) + weight);
        }

        return itemsMap.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(e -> {
                    List<Integer> list = new ArrayList<>();
                    list.add(e.getKey());
                    list.add(e.getValue());
                    return list;
                })
                .collect(Collectors.toList());
    }

    private List<Integer> createResultList(int value, int weigh) {
        List<Integer> result = new ArrayList<>();
        result.add(value);
        result.add(weigh);
        return result;
    }
}
