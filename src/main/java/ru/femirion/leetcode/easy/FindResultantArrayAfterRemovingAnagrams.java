package ru.femirion.leetcode.easy;

import java.util.*;

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

    /**
     * Runtime 2ms Beats 92.64% of users with Java
     * Memory 43.80MB Beats 68.47% of users with Java
     */
    public List<String> removeAnagrams1(String[] words) {
        List<String> result = new ArrayList<>();

        int[] word1 = new int[26];
        int[] word2 = new int[26];

        int p = 1;
        for (int i = 0; i < words.length; i++) {
            toSkeleton(words[i], word1);
            if (p == words.length) {
                word2 = new int[0];
            } else {
                toSkeleton(words[p], word2);
            }

            if (!Arrays.equals(word1, word2)) {
                result.add(words[i]);
                i = p - 1;
            } else {
                i--;
            }
            p++;
        }

        return result;
    }

    private void toSkeleton(String source, int[] result) {
        for (int i = 0; i < 26; i++) {
            result[i] = 0;
        }
        for (int i = 0; i < source.length(); i++) {
            char current = source.charAt(i);
            int index = current - 'a';
            result[index] = result[index] + 1;
        }
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
