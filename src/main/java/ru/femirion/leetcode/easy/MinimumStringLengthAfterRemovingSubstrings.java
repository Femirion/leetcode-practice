package ru.femirion.leetcode.easy;

/**
 * 2696. Minimum String Length After Removing Substrings
 * https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
 */
public class MinimumStringLengthAfterRemovingSubstrings {
    /**
     * Runtime 27ms Beats 7.98% of users with Java
     * Memory 44.76MB Beats 7.23% of users with Java
     */
    public int minLength(String s) {
        final String AB = "AB";
        final String CD = "CD";
        while (s.contains(AB) || s.contains(CD)) {
            s = s.replaceAll(AB, "");
            s = s.replaceAll(CD, "");
        }
        return s.length();
    }
}
