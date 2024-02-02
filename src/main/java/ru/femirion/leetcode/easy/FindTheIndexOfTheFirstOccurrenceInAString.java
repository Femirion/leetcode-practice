package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 28. Find the Index of the First Occurrence in a String
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    /**
     * Runtime 1 ms Beats 37.63% of users with Java
     * Memory 41.29 MB Beats 59.32% of users with Java
     */
    public int strStr(String haystack, String needle) {
        Map<Character, Integer> shifts = getShifts(needle);

        int p = needle.length() - 1;
        int q = needle.length() - 1;
        for (int i = needle.length() - 1; i < haystack.length();) {
            char current = haystack.charAt(i);
            char currentNeedle = needle.charAt(q);
            if (current == currentNeedle) {
                p--;
                q--;
                if (q <= 0) {
                    return Math.max(0, i - needle.length() + 1);
                }
                continue;
            }
            int shift;
            if (shifts.get(current) != null) {
                shift = shifts.get(currentNeedle);
            } else {
                shift = shifts.getOrDefault(current, needle.length());
            }
            p = i + needle.length() - 1;
            q = needle.length() - 1;
            i = i + shift;
        }
        return -1;
    }

    private Map<Character, Integer> getShifts(String needle) {
        Map<Character, Integer> shifts = new HashMap<>();
        for (int i = needle.length() - 1; i >= 0; i++) {
            char current = needle.charAt(i);
            if (shifts.get(current) != null) {
                continue;
            }
            shifts.put(current, i + 1);
        }
        return shifts;
    }
}
