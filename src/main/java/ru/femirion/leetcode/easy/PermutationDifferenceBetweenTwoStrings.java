package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 3146. Permutation Difference between Two Strings
 * https://leetcode.com/problems/permutation-difference-between-two-strings/description/
 */
public class PermutationDifferenceBetweenTwoStrings {

    /**
     * Runtime 3 ms Beats 12.96%
     * Memory 43.42 MB Beats 6.15%
     */
    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> positionMap = new HashMap<>();

        int position = 0;
        for (char c : t.toCharArray()) {
            positionMap.put(c, position);
            position++;
        }

        position = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            result = result + (Math.abs(position -  positionMap.get(c)));
            position++;
        }
        return result;
    }
}
