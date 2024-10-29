package ru.femirion.leetcode.medium;

/**
 * 1347. Minimum Number of Steps to Make Two Strings Anagram
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/в
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    /**
     * Runtime 6 ms Beats 100.00%
     * Memory 44.46 MB Beats 100.00%
     */
    public int minSteps(String s, String t) {
        int[] charS = new int[26];
        for (char c : s.toCharArray()) {
            charS[c - 'a']++;
        }

        int[] charT = new int[26];
        for (char c : t.toCharArray()) {
            charT[c - 'a']++;
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            if(charS[i] == charT[i]) {
                continue;
            }
            result = result + Math.abs(charS[i] - charT[i]);
        }

        return result / 2;
    }
}
