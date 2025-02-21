package ru.femirion.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 916. Word Subsets
 * https://leetcode.com/problems/word-subsets/description/
 */
public class WordSubsets {

    /**
     * Runtime 19 ms Beats 13.24%
     * Memory 54.21 MB Beats 68.03%
     */
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] arr = new int[26];
        Set<String> result =  new HashSet<>();

        for (String w : words2) {
            int[] tmpArr = new int[26];
            for (char c : w.toCharArray()) {
                tmpArr[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                arr[i] = Math.max(arr[i], tmpArr[i]);
            }
        }

        for (String w : words1) {
            int[] chars = new int[26];
            for (char c : w.toCharArray()) {
                chars[c - 'a']++;
            }

            boolean canBeAdded = true;
            for (int i = 0; i < 26; i++) {
                int countInMap = arr[i];
                int countInStr = chars[i];

                if (0 < countInMap && countInStr == 0 || countInStr < countInMap) {
                    canBeAdded = false;
                    break;
                }
            }
            if (canBeAdded) {
                result.add(w);
            }
        }

        return new ArrayList<>(result);
    }
}
