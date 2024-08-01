package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 692. Top K Frequent Words
 * https://leetcode.com/problems/top-k-frequent-words/description/
 */
public class TopKFrequentWords {

    /**
     * Runtime 6 ms Beats 98.21%
     * Memory 44.25 MB Beats 95.30%
     */
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> wordsCounts = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> items = new PriorityQueue<>((a, b) -> {
            if (!Objects.equals(a.getValue(), b.getValue())) {
                return a.getValue() - b.getValue();
            } else {
                return b.getKey().compareTo(a.getKey());
            }
        });

        for (String cur : words) {
            wordsCounts.put(cur, wordsCounts.getOrDefault(cur, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry: wordsCounts.entrySet()) {
            items.offer(entry);
            if (k < items.size()) {
                items.poll();
            }
        }

        while(!items.isEmpty()) {
            result.add(items.poll().getKey());
        }

        Collections.reverse(result);
        return result;
    }
}
