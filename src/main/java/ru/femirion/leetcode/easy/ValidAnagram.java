package ru.femirion.leetcode.easy;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] s1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int currentPosition = getPosition(s.charAt(i));
            s1[currentPosition] = s1[currentPosition] + 1;
        }

        int[] s2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int currentPosition = getPosition(t.charAt(i));
            s2[currentPosition] = s2[currentPosition] + 1;
        }

        return Arrays.equals(s1, s2);
    }

    private int getPosition(char currentChar) {
        switch (currentChar) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            case 'i':
                return 8;
            case 'j':
                return 9;
            case 'k':
                return 10;
            case 'l':
                return 11;
            case 'm':
                return 12;
            case 'n':
                return 13;
            case 'o':
                return 14;
            case 'p':
                return 15;
            case 'q':
                return 16;
            case 'r':
                return 17;
            case 's':
                return 18;
            case 't':
                return 19;
            case 'u':
                return 20;
            case 'v':
                return 21;
            case 'w':
                return 22;
            case 'x':
                return 23;
            case 'y':
                return 24;
            case 'z':
                return 25;

        }
        return -1;
    }

}
