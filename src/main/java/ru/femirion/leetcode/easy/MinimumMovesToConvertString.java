package ru.femirion.leetcode.easy;

/**
 * 2027. Minimum Moves to Convert String
 * https://leetcode.com/problems/minimum-moves-to-convert-string/description/
 */
public class MinimumMovesToConvertString {


    /**
     * Runtime 1 ms Beats 88.86% of users with Java
     * Memory 41.40 MB Beats 63.64% of users with Java
     */
    public int minimumMoves1(String s) {
        int count = 0;
        char cur;
        for (int i = 0; i < s.length(); i = i + 3) {
            cur = s.charAt(i);
            if (cur == 'O') {
                i = i - 2;
                continue;
            }
            count++;
        }
        return count;
    }

    /**
     * Runtime 2 ms Beats 10.26% of users with Java
     * Memory 41.85 MB Beats 7.92% of users with Java
     */
    public int minimumMoves(String s) {
        int count = 0;
        char cur;
        char next1;
        char next2;
        for (int i = 0; i < s.length(); i = i + 3) {
            cur = s.charAt(i);

            if (cur == 'O') {
                i = i - 2;
                continue;
            }

            next1 = i + 1 >= s.length() ? 'O' : s.charAt(i + 1);
            next2 = i + 2 >= s.length() ? 'O' : s.charAt(i + 2);
            if (cur != 'O' || next1 != 'O' || next2 != 'O') {
                count++;
            }
        }
        return count;
    }
}
