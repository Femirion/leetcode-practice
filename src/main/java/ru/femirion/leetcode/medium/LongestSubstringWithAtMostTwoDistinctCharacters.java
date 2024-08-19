package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    /**
     * Runtime 43 ms Beats 49.61%
     * Memory 45.68 MB Beats 10.04%
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> countsOfChar = new HashMap<>();

        char[] chars = s.toCharArray();

        int maxLength = 0;
        int curLength = 0;
        int countOfDiff = 0;

        int start = 0;
        int end = 0;

        while (end < chars.length) {
            char endChar = chars[end];
            if (countsOfChar.get(endChar) != null) {
                countsOfChar.put(endChar, countsOfChar.get(endChar) + 1);
                end++;
            } else {
                if (countOfDiff < 2) {
                    countsOfChar.put(endChar, 1);
                    countOfDiff++;
                    end++;
                } else {
                    while (start < end - 1) {
                        char startChar = chars[start];
                        int curCount = countsOfChar.get(startChar);
                        if (curCount == 1) {
                            countsOfChar.remove(startChar);
                            countOfDiff--;
                            start++;
                            break;
                        } else {
                            countsOfChar.put(startChar, countsOfChar.get(startChar) - 1);
                            start++;
                        }
                    }
                }
            }
            maxLength = Math.max(maxLength, end - start);
        }


        return maxLength;
    }
}
