package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2942. Find Words Containing Character
 * https://leetcode.com/problems/find-words-containing-character/description/
 */
public class FindWordsContainingCharacter {

    /**
     * Runtime 2 ms Beats 57.75%
     * Memory 45.14 MB Beats 9.31%
     */
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        int wordIdx = 0;
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if (c == x) {
                    result.add(wordIdx);
                    break;
                }
            }
            wordIdx++;
        }
        return result;
    }
}
