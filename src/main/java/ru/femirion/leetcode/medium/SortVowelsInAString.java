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

    /**
     * Runtime 17 ms Beats 92.68%
     * Memory 45.70 MB Beats 86.59%
     */
    public String sortVowels2(String s) {
        int[] counts = new int[10];

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                counts[getIdx(c)]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                while (counts[idx] == 0) {
                    idx++;
                }
                sb.append(getVowel(idx));
                counts[idx]--;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private char getVowel(int idx) {
        switch(idx) {
            case 0 : return 'A';
            case 1 : return 'E';
            case 2 : return 'I';
            case 3 : return 'O';
            case 4 : return 'U';
            case 5 : return 'a';
            case 6 : return 'e';
            case 7 : return 'i';
            case 8 : return 'o';
            case 9 : return 'u';
        }
        return 'B';
    }

    private int getIdx(char c) {
        switch(c) {
            case 'A' : return 0;
            case 'E' : return 1;
            case 'I' : return 2;
            case 'O' : return 3;
            case 'U' : return 4;
            case 'a' : return 5;
            case 'e' : return 6;
            case 'i' : return 7;
            case 'o' : return 8;
            case 'u' : return 9;
        }
        return -1;
    }
}
