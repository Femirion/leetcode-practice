package ru.femirion.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1657. Determine if Two Strings Are Close
 * https://leetcode.com/problems/determine-if-two-strings-are-close/description/
 */
public class DetermineIfTwoStringsAreClose {

    /**
     * Runtime 72 ms Beats 14.57% of users with Java
     * Memory 45.04 MB Beats 98.25% of users with Java
     */
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        char c;
        for (int i = 0; i < word1.length(); i++) {
            c = word1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            c = word2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        List<Integer> counts1 = map1.values().stream().sorted().toList();
        List<Integer> counts2 = map2.values().stream().sorted().toList();

        return counts1.equals(counts2);
    }

    /**
     * Runtime 10 ms Beats 76.31% of users with Java
     * Memory 45.14 MB Beats 96.20% of users with Java
     */
    public boolean closeStrings1(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        int c;
        for (int i = 0; i < word1.length(); i++) {
            c = word1.charAt(i) - 'a';
            arr1[c]  = arr1[c] + 1;
        }

        for (int i = 0; i < word2.length(); i++) {
            c = word2.charAt(i) - 'a';
            arr1[c]  = arr2[c] + 1;
        }

        for (int i = 0; i < 26; i++) {
            if (arr1[i] != 0 && arr2[i] == 0 || arr2[i] != 0 && arr1[i] == 0) {
                return false;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
