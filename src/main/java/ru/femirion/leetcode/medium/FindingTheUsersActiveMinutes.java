package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1817. Finding the Users Active Minutes
 * https://leetcode.com/problems/finding-the-users-active-minutes/description/
 */
public class FindingTheUsersActiveMinutes {

    /**
     * Runtime 17 ms Beats 90.40%
     * Memory 56.86 MB Beats 43.94%
     */
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] result = new int[k];

        Map<Integer, Set<Integer>> uam = new HashMap<>();

        for (int[] log : logs) {
            Set<Integer> unicMinutes = uam.getOrDefault(log[0], new HashSet<>());
            unicMinutes.add(log[1]);
            uam.put(log[0], unicMinutes);
        }

        for (var unicMinutes : uam.values()) {
            result[unicMinutes.size() - 1]++;
        }
        return result;
    }
}
