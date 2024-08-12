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
