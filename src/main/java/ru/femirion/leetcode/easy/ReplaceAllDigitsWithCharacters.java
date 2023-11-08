package ru.femirion.leetcode.easy;

/**
 * 1844. Replace All Digits with Characters
 * https://leetcode.com/problems/replace-all-digits-with-characters/
 */
public class ReplaceAllDigitsWithCharacters {
    /**
     * Runtime 0ms Beats 100.00% of users with Java
     * Memory 0.02MB Beats 96.67% of users with Java
     */
    public String replaceDigits(String s) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i = i + 2) {
            char current = s.charAt(i);
            result.append(current);
            if (i + 1 == s.length()) {
                break;
            }
            char shift = s.charAt(i + 1);
            result.append(getShifted(current, shift));
        }
        return result.toString();
    }

    private char getShifted(char current, char numberChar) {
        byte number = 0;
        switch (numberChar) {
            case  '1': {
                number = 1;
                break;
            }
            case  '2': {
                number = 2;
                break;
            }
            case  '3': {
                number = 3;
                break;
            }
            case  '4': {
                number = 4;
                break;
            }
            case  '5': {
                number = 5;
                break;
            }
            case  '6': {
                number = 6;
                break;
            }
            case  '7': {
                number = 7;
                break;
            }
            case  '8': {
                number = 8;
                break;
            }
            case  '9': {
                number = 9;
                break;
            }
        }
        return (char) (current + number);
    }
}
