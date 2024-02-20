package ru.femirion.leetcode.medium;

import java.util.LinkedList;

/**
 * 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class ReverseWordsInAString {

    /**
     * Runtime 9 ms Beats 47.46% of users with Java
     * Memory 43.27 MB Beats 58.35% of users with Java
     */
    public String reverseWords(String s) {
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (!sb.isEmpty()) {
                    list.addFirst(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(c);
            }
        }

        if (!sb.isEmpty()) {
            list.addFirst(sb.toString());
        }

        return String.join(" ", list);
    }
}
