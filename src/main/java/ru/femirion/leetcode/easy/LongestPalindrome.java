package ru.femirion.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome/description/
 */
public class LongestPalindrome {

    /**
     * Runtime 9 ms Beats 25.98% of users with Java
     * Memory 41.79 MB Beats 42.79% of users with Java
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i  < s.length(); i++) {
            char current = s.charAt(i);
            counts.put(current, counts.getOrDefault(current, 0) + 1 );
        }

        int result = 0;
        boolean hasOdd = false;
        for (int v : counts.values()) {
            if (v % 2 != 0) {
                if (!hasOdd) {
                    hasOdd = true;
                    result = result + v;
                } else {
                    result = result + v - 1;
                }
            } else {
                result = result + v;
            }
        }
        return result;
    }

}
