package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. Verifying an Alien Dictionary
 * https://leetcode.com/problems/verifying-an-alien-dictionary/description/
 */
public class VerifyingAnAlienDictionary {

    /**
     * Runtime 1 ms Beats 56.88%
     * Memory 41.99 MB Beats 53.49%
     */
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            dictionary.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            String cur = words[i];
            String prev = words[i - 1];
            int minLength = Math.min(cur.length(), prev.length());
            boolean hasDiff = false;
            for (int j = 0; j < minLength; j++) {
                int curCharIdx = dictionary.get(cur.charAt(j));
                int prevCharIdx = dictionary.get(prev.charAt(j));
                if (curCharIdx == prevCharIdx) {
                    continue;
                }
                if (curCharIdx < prevCharIdx) {
                    return false;
                } else {
                    hasDiff = true;
                    break;
                }
            }
            if (!hasDiff && cur.length() < prev.length()) {
                return false;
            }
        }
        return true;
    }
}
