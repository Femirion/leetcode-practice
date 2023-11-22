package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

    /**
     * Runtime 7ms Beats 86.40% of users with Java
     * Memory 41.70MB Beats 25.61% of users with Java
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Set<Character> usedChars = new HashSet<>();
        Map<Character, Character> mappings = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            Character mappedChar = mappings.get(current);
            if (mappedChar != null) {
                if (mappedChar != t.charAt(i)) {
                    return false;
                }
            } else {
                char fromT = t.charAt(i);
                if (!usedChars.contains(fromT)) {
                    mappings.put(current, fromT);
                    usedChars.add(fromT);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
