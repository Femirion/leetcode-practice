package ru.femirion.leetcode.medium;

import java.util.*;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/?envType=daily-question&envId=2024-02-06
 */
public class GroupAnagrams {

    /**
     * Runtime 7 ms Beats 57.75% of users with Java
     * Memory 47.31 MB Beats 74.71% of users with Java
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String tmp = new String(arr);
            List<String> list = map.getOrDefault(tmp, new ArrayList<>());
            list.add(strs[i]);
            map.put(tmp, list);
        }

        return new ArrayList<>(map.values());
    }
}
