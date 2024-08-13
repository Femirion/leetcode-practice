package ru.femirion.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestRepeatingCharacterReplacement {

    /**
     * Runtime 5 ms Beats 98.15%
     * Memory 42.88 MB Beats 36.05%
     */
    public int characterReplacement2(String s, int k) {
        char[] arr = s.toCharArray();
        int[] counts = new int[26];
        int maxCount = 0;

        int maxLength = 0;
        int L = 0;
        for (int R = 0; R < arr.length; R++) {
            counts[arr[R] - 'A']++;

            if (maxCount < counts[arr[R] - 'A']) {
                maxCount = counts[arr[R] - 'A'];
            }

            if (k < R - L + 1 - maxCount) {
                counts[arr[L] - 'A']--;
                L++;
            }

            if (maxLength < R - L + 1) {
                maxLength = R - L + 1;
            }
        }

        return maxLength;
    }

    /**
     * Runtime 28 ms Beats 25.69%
     * Memory 45.38 MB Beats 6.07%
     */
    public int characterReplacement(String s, int k) {
        int max = 0;
        char[] arr = s.toCharArray();
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            chars.add(arr[i]);
        }

        for (int i = 0; i < chars.size(); i++) {
            int curCount = k;
            int curLength = 0;
            LinkedList<Integer> diffPos = new LinkedList<>();
            for (int j = 0; j < arr.length; j++) {
                int curChar = arr[j] - 'A';
                if (curChar == i) {
                    curLength++;
                } else if (0 < curCount) {
                    curLength++;
                    curCount--;
                    diffPos.addLast(j);
                } else {
                    if (0 < k) {
                        int firstPos = diffPos.removeFirst();
                        curLength = j - firstPos;
                        diffPos.addLast(j);
                    } else {
                        if (max < curLength) {
                            max = curLength;
                        }
                        curLength = 0;
                    }
                }

                if (max < curLength) {
                    max = curLength;
                }
            }
        }

        return max;
    }
}
