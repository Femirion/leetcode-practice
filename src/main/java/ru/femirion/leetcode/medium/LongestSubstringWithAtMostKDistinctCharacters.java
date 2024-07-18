package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    /**
     * Runtime 7 ms Beats 80.35%
     * Memory 44.39 MB Beats 58.65%
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> chars = new HashMap<>();

        int curSize = 0;
        int countOfDiff = 0;
        int max = 0;
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int curVal = chars.getOrDefault(cur, 0);
            if (0 < curVal) {
                curSize++;
                curVal++;
                chars.put(cur, curVal);
                if (max < curSize) {
                    max = curSize;
                }
                continue;
            }

            if (countOfDiff < k) {
                curSize++;
                countOfDiff++;
                chars.put(cur, 1);
                if (max < curSize) {
                    max = curSize;
                }
                continue;
            }

            while(p < i) {
                char pChar = s.charAt(p);
                int pVal = chars.getOrDefault(pChar, 1);
                p++;
                pVal--;
                curSize--;
                chars.put(pChar, pVal);
                if (pVal == 0) {
                    countOfDiff--;
                    chars.put(pChar, 0);
                    curVal = chars.getOrDefault(cur, 0);
                    if (curVal == 0) {
                        countOfDiff++;
                    }
                    curSize++;
                    curVal++;
                    chars.put(cur, curVal);
                    if (max < curSize) {
                        max = curSize;
                    }
                    break;
                }
            }
        }
        return max;
    }
}
