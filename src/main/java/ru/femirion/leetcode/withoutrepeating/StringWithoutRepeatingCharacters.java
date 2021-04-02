package ru.femirion.leetcode.withoutrepeating;

import java.util.Arrays;
import java.util.HashSet;

public class StringWithoutRepeatingCharacters {
    /*
    Given a string s, find the length of the longest substring without repeating characters.

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Example 4:
    Input: s = ""
    Output: 0

    Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.*/


    /*
    * Runtime: 73 ms, faster than 16.95% of Java online submissions for Longest Substring Without Repeating Characters.
    * Memory Usage: 40 MB, less than 14.14% of Java online submissions for Longest Substring Without Repeating Characters.
    *
    * */
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
