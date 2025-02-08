package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 2349. Design a Number Container System
 * https://leetcode.com/problems/design-a-number-container-system/description/
 */
public class DesignANumberContainerSystem {


    private Map<Integer, TreeSet<Integer>> container = new HashMap<>();
    private Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     * Runtime 71 ms Beats 71.23%
     * Memory 100.05 MB Beats 35.62%
     */
    public void change(int index, int number) {
        TreeSet<Integer> indexes = container.getOrDefault(number, new TreeSet<>());
        indexes.add(index);

        int oldNumber = indexMap.getOrDefault(index, -1);
        if (oldNumber != -1 && number != oldNumber) {
            TreeSet<Integer> oldNumberIndexes = container.getOrDefault(oldNumber, new TreeSet<>());
            oldNumberIndexes.remove(index);
            container.put(oldNumber, oldNumberIndexes);
        }
        indexMap.put(index, number);
        container.put(number, indexes);
    }

    public int find(int number) {
        TreeSet<Integer> indexes = container.get(number);
        if (indexes == null || indexes.isEmpty()) {
            return -1;
        }
        return indexes.first();
    }
}
