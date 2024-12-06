package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */
public class InsertDeleteGetRandom {

    private Map<Integer, Integer> values = new HashMap<>();
    private List<Integer> indexes = new ArrayList<>();
    private Random rnd = new Random();

    /**
     * Runtime 25 ms Beats 78.33%
     * Memory 93.77 MB Beats 16.26%
     */
    public boolean insert(int val) {
        Integer index = values.get(val);
        if (index != null) {
            return false;
        }

        indexes.add(val);
        values.put(val, indexes.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        Integer index = values.get(val);
        if (index == null) {
            return false;
        }

        int lastValue = indexes.get(indexes.size() - 1);
        indexes.set(index, lastValue);
        indexes.remove(indexes.size() - 1);
        values.put(lastValue, index);
        values.remove(val);
        return true;
    }

    public int getRandom() {
        int rndIndx = rnd.nextInt(0, indexes.size());
        return indexes.get((Integer) rndIndx);
    }
}
