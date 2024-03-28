package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {

    /**
     * Runtime 40 ms Beats 5.04% of users with Java
     * Memory 48.13 MB Beats 71.93% of users with Java
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberToCount = new HashMap<>();
        TreeMap<Integer, Set<Integer>> countToNumbers = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            int curValue = nums[i];
            Integer count = numberToCount.get(curValue);
            if (count == null) {
                numberToCount.put(curValue, 1);
                Set<Integer> numbers = countToNumbers.getOrDefault(1, new HashSet<>());
                numbers.add(curValue);
                countToNumbers.put(1, numbers);
            } else {
                numberToCount.remove(curValue);
                int newCount = count + 1;
                numberToCount.put(curValue, newCount);

                Set<Integer> numbers = countToNumbers.get(count);
                numbers.remove(curValue);
                countToNumbers.put(count, numbers);

                Set<Integer> nextNumbers = countToNumbers.getOrDefault(newCount, new HashSet<>());
                nextNumbers.add(curValue);
                countToNumbers.put(newCount, nextNumbers);
            }
        }

        int i = 0;
        int[] result = new int[k];
        int n = k;
        while (0 < n) {
            if (countToNumbers.isEmpty()) {
                break;
            }
            Set<Integer> numbers = countToNumbers.pollFirstEntry().getValue();
            if (numbers.isEmpty()) {
                continue;
            }
            for (int val : numbers) {
                result[i] = val;
                if (i == k) {
                    break;
                }
                i++;
            }
            n = n - numbers.size();
        }
        return result;
    }
}
