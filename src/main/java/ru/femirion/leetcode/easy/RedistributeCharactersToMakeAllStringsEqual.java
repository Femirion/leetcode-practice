package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1897. Redistribute Characters to Make All Strings Equal
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
 */
public class RedistributeCharactersToMakeAllStringsEqual {

    /**
     * Runtime 11 ms Beats 45.85% of users with Java
     * Memory 44.66 MB Beats 5.13% of users with Java
     */
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> counts = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> e : counts.entrySet()) {
            if (e.getValue() % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Runtime 2 ms Beats 93.82% of users with Java
     * Memory 43.96 MB Beats 54.00% of users with Java
     */
    public boolean makeEqual1(String[] words) {
        char[] counts = new char[26];

        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                counts[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (counts[i] % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
