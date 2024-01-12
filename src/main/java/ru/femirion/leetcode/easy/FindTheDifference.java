package ru.femirion.leetcode.easy;

/**
 * 389. Find the Difference
 * https://leetcode.com/problems/find-the-difference/description/
 */
public class FindTheDifference {

    /**
     * Runtime 3 ms Beats 46.81% of users with Java
     * Memory 41.72 MB Beats 25.72% of users with Java
     */
    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            chars[current - 'a'] = chars[current - 'a'] + 1;
        }
        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            chars[current - 'a'] = chars[current - 'a'] - 1;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == -1) {
                return (char) ('a' + i);
            }
        }
        return ' ';
    }
}
