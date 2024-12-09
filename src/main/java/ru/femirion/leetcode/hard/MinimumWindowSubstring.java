package ru.femirion.leetcode.hard;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
public class MinimumWindowSubstring {

    /**
     * Runtime 111 ms Beats 19.34%
     * Memory 45.96 MB Beats 6.63%
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        String result = s;

        int[] pattern = new int[52];
        for (char c : t.toCharArray()) {
            pattern[getIndex(c)]++;
        }

        if (s.length() == t.length()) {
            int[] sPattern = new int[52];
            for (char c : s.toCharArray()) {
                sPattern[getIndex(c)]++;
            }
            return contains(pattern, sPattern) ? s : "";
        }

        int[] sPattern = new int[52];
        char[] chars = s.toCharArray();
        int startPos = 0;
        boolean resultWasFound = false;
        for (int i = 0; i < s.length(); i++) {
            sPattern[getIndex(chars[i])]++;
            if (i - startPos + 1 < t.length()) {
                continue;
            }
            boolean isContains = contains(pattern, sPattern);
            if (!isContains) {
                continue;
            }
            while (isContains) {
                if (i - startPos < result.length()) {
                    result = s.substring(startPos, i + 1);
                    resultWasFound = true;
                }
                sPattern[getIndex(chars[startPos])]--;
                startPos++;
                isContains = contains(pattern, sPattern);
            }
        }

        return !resultWasFound ? "" : result;
    }

    private boolean contains(int[] pattern, int[] arr) {
        for (int i = 0; i < pattern.length; i++) {
            if (arr[i] < pattern[i]) {
                return false;
            }
        }
        return true;
    }


    private int getIndex(char c) {
        if ('A' <= c && c <= 'X') {
            return c - 'A';
        } else {
            return c - 'a' + 26;
        }
    }
}
