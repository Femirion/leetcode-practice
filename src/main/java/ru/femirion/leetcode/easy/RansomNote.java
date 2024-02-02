package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/description/
 */
public class RansomNote {
    /**
     * Runtime 16 ms Beats 24.09% of users with Java
     * Memory 45.26 MB Beats 17.19% of users with Java
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char current = ransomNote.charAt(i);
            int count = map.getOrDefault(current, 0);
            if (count == 0) {
                return false;
            }
            map.put(current, count - 1);
        }
        return true;
    }
}
