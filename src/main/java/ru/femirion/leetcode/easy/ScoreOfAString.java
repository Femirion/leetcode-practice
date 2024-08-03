package ru.femirion.leetcode.easy;

/**
 * 3110. Score of a String
 * https://leetcode.com/problems/score-of-a-string/description/
 */
public class ScoreOfAString {

    /**
     * Runtime 1 ms Beats 99.84%
     * Memory 41.99 MB Beats 38.02%
     */
    public int scoreOfString(String s) {
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            result = result + Math.abs(s.charAt(i) - s.charAt(i - 1));
        }

        return result;
    }
}
