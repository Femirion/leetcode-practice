package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884. Uncommon Words from Two Sentences
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 */
public class UncommonWordsFromTwoSentences {

    /**
     * Runtime 2 ms Beats 100.00%
     * Memory 41.68 MB Beats 96.72%
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        Map<String, Integer> existedWords = new HashMap<>();
        for (String w : words1) {
            existedWords.put(w, existedWords.getOrDefault(w, 0) + 1);
        }

        for (String w : words2) {
            existedWords.put(w, existedWords.getOrDefault(w, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> e : existedWords.entrySet()) {
            if (e.getValue() == 1) {
                result.add(e.getKey());
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
