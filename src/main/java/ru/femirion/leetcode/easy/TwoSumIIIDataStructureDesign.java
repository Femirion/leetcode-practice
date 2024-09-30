package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 170. Two Sum III - Data structure design
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
 */
public class TwoSumIIIDataStructureDesign {

    private Map<Integer, Integer> existedNums;

    /**
     * Runtime 89 ms Beats 47.40%
     * Memory 52.51 MB Beats 41.29%
     */
    public TwoSumIIIDataStructureDesign() {
        existedNums = new HashMap<>();
    }

    public void add(int number) {
        existedNums.put(number, existedNums.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        var x = existedNums;
        for (Map.Entry<Integer, Integer> e : existedNums.entrySet()) {
            int curValue = e.getKey();
            int diff = value - curValue;

            Integer diffCount = existedNums.get(diff);

            if (diff == curValue) {
                if (2 <= diffCount) {
                    return true;
                }
            } else {
                if (diffCount != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
