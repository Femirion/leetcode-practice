package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2273. Find Resultant Array After Removing Anagrams
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 */
public class FindResultantArrayAfterRemovingAnagrams {

    /**
     * Runtime 8ms Beats 9.72%of users with Java
     * Memory 43.90MB Beats 57.78%of users with Java
     */
    public List<String> removeAnagrams(String[] words) {
        Map<String, Map<Character, Integer>> anagrams = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            anagrams.put(words[i], getSkeleton(words[i]));
            result.add(words[i]);
        }

        for (int i = 0; i < result.size() - 1; i++) {
            String firstWord = result.get(i);
            String secondWord = result.get(i + 1);
            Map<Character, Integer> first = anagrams.get(firstWord);
            Map<Character, Integer> secondSkeleton = anagrams.get(secondWord);
            if (areAnagrams(first, secondSkeleton)) {
                result.remove(i + 1);
                i = i - 1;
            }
        }

        return result;
    }

    private Map<Character, Integer> getSkeleton(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            result.put(current, result.getOrDefault(current, 0) + 1);
        }
        return result;
    }

    private boolean areAnagrams(Map<Character, Integer> anagram1, Map<Character, Integer> anagram2) {
        return anagram1.equals(anagram2);
    }
}
