package ru.femirion.leetcode.easy;

import java.util.*;

/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class FirstUniqueCharacterInAString {

    /**
     * Runtime 20 ms Beats 59.44% of users with Java
     * Memory 44.80 MB Beats 50.81% of users with Java
     */
    public int firstUniqChar(String s) {
        Set<Character> characterSet = new HashSet<>();
        Map<Character, Integer> result = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (characterSet.contains(current)) {
                result.remove(current);
            } else {
                characterSet.add(current);
                result.put(current, i);
            }
        }
        if (result.isEmpty()) {
            return -1;
        }
        return new ArrayList<>(result.values()).get(0);
    }
}
