package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/description/
 */
public class WordPattern {

    /**
     * Runtime 1 ms Beats 80.39% of users with Java
     * Memory 41.20 MB Beats 81.96% of users with Java
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<String, Character> map = new HashMap<>();
        Set<Character> usedChars = new HashSet<>();
        char cur;

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            cur = pattern.charAt(i);
            String word = words[i];
            Character c = map.get(word);
            if (c == null) {
                if (!usedChars.contains(cur)) {
                    map.put(word, cur);
                    usedChars.add(cur);
                } else {
                    return false;
                }
            } else {
                if (!c.equals(cur)) {
                    return false;
                }
            }
        }
        return true;
    }
}
