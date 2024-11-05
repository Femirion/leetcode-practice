package ru.femirion.leetcode.medium;

import java.util.PriorityQueue;

/**
 * 2785. Sort Vowels in a String
 * https://leetcode.com/problems/sort-vowels-in-a-string/description/
 */
public class SortVowelsInAString {

    /**
     * Runtime 82 ms Beats 23.58%
     * Memory 48.25 MB Beats 28.57%
     */
    public String sortVowels(String s) {
        PriorityQueue<Character> queue = new PriorityQueue<>();

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append(queue.poll());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a'
                || c == 'A'
                || c == 'e'
                || c == 'E'
                || c == 'i'
                || c == 'I'
                || c == 'o'
                || c == 'O'
                || c == 'u'
                || c == 'U';
    }
}
