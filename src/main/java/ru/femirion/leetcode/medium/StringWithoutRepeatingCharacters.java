package ru.femirion.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class StringWithoutRepeatingCharacters {

    /**
     * Runtime: 73 ms, faster than 16.95% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 40 MB, less than 14.14% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int currentLength = 0;
        int currentIndex = 0;
        HashSet<Character> uniqChars = new HashSet<>();
        for (char current : chars) {
            for (int i = currentIndex; i < chars.length; i++) {
                if (!uniqChars.contains(chars[i])) {
                    uniqChars.add(chars[i]);
                    currentLength++;
                } else {
                    if (currentLength > max) {
                        max = currentLength;
                    }
                    currentLength = 1;
                    uniqChars.clear();
                    uniqChars.add(current);
                    break;
                }
            }
            currentIndex++;
        }

        if (currentLength > max) {
            max = currentLength;
        }
        return max;
    }

    /*
    * Runtime: 5 ms, faster than 79.42% of Java online submissions for Longest Substring Without Repeating Characters.
    * Memory Usage: 38.9 MB, less than 74.46% of Java online submissions for Longest Substring Without Repeating Characters.
    * */
    public int lengthOfLongestSubstringFastVersion(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int currentLength = 0;

        int[] charsMap = new int[128];
        Arrays.fill(charsMap, -1);

        for (int i = 0; i < chars.length; i++) {
            var current = chars[i];
            var position = charsMap[current];
            if (position == -1) {
                charsMap[current] = i;
                currentLength++;
            } else {
                for (int j = 0; j < 128; j++) {
                    var value = charsMap[j];
                    if (value < position) {
                        charsMap[j] = -1;
                    }
                }
                charsMap[current] = i;
                currentLength = i - position;
            }

            if (currentLength > max) {
                max = currentLength;
            }
        }

        return max;
    }
}
