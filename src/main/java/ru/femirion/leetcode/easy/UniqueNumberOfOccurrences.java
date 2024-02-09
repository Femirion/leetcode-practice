package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. Unique Number of Occurrences
 * https://leetcode.com/problems/unique-number-of-occurrences/description/
 */
public class UniqueNumberOfOccurrences {

    /**
     * Runtime 2 ms Beats 96.44% of users with Java
     * Memory 41.24 MB Beats 92.39% of users with Java
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int e : map.values()) {
            if (set.contains(e)) {
                return false;
            } else {
                set.add(e);
            }
        }
        return true;
    }
}
