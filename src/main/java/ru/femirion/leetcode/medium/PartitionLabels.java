package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/description/
 */
public class PartitionLabels {

    /**
     * Runtime 15 ms Beats 6.85%
     * Memory 42.54 MB Beats 18.92%
     */
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> startPoss = new HashMap<>();
        Map<Character, Integer> endPoss = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (startPoss.get(cur) == null) {
                startPoss.put(cur, i);
            }
            if (endPoss.get(cur) != null) {
                int curEnd = endPoss.get(cur);
                if (curEnd < i) {
                    endPoss.put(cur, i);
                }
            } else {
                endPoss.put(cur, i);
            }
        }

        int start = 0;
        int end = 0;
        int startC;
        int endC;
        int lengthC = 1;
        int curLength = 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            startC = startPoss.get(cur);
            endC = endPoss.get(cur);
            if (end < endC) {
                end = endC;
            }
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
                end = i + 1;
            }
        }

        return result;
    }
}
