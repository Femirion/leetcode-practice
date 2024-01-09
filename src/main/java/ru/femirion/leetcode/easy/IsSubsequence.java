package ru.femirion.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    /**
     * Runtime 2ms Beats 38.64% of users with Java
     * Memory 41.32MB Beats 25.55% of users with Java
     */
    public boolean isSubsequence(String s, String t) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            characterSet.add(s.charAt(i));
        }

        int p = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            if (characterSet.contains(current) && s.charAt(p) == current) {
                sb.append(current);
                p++;
            }
        }
        return sb.toString().contains(s);
    }

    /**
     * Runtime 1ms Beats 91.97% of users with Java
     * Memory 41.48MB Beats 19.55% of users with Java
     */
    public boolean isSubsequence1(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            arr[current - 'a'] = 1;
        }

        int p = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            if (checkThatCharacterContainsInPattern(current, arr) && s.charAt(p) == current) {
                sb.append(current);
                p++;
            }
        }
        return sb.toString().contains(s);
    }

    private boolean checkThatCharacterContainsInPattern(char e, int[] arr) {
        return arr[e - 'a'] != 0;
    }

}
