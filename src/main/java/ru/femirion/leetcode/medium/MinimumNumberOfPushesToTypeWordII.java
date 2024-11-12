package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 3016. Minimum Number of Pushes to Type Word II
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/
 */
public class MinimumNumberOfPushesToTypeWordII {

    /**
     * Runtime 109 ms Beats 5.60%
     * Memory 45.70 MB Beats 42.89%
     */
    public int minimumPushes(String word) {
        int count = 0;

        Map<Character, Integer> counterMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedCounterList = counterMap.entrySet().stream()
                .sorted((x, y) -> y.getValue() - x.getValue())
                .collect(Collectors.toList());

        int total = 1;
        int current = 0;
        Map<Character, Integer> newMapping = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : sortedCounterList) {
            if (current != 0 && current % 8 == 0) {
                total++;
                current = 1;
            } else {
                current++;
            }
            newMapping.put(entry.getKey(), total);
        }

        for (char c : word.toCharArray()) {
            count = count + newMapping.get(c);
        }

        return count;
    }
}
