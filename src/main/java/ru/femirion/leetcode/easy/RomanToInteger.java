package ru.femirion.leetcode.easy;

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    /**
     * Runtime: 4 ms, faster than 93.32% of Java online submissions for Roman to Integer.
     * Memory Usage: 42.4 MB, less than 92.83% of Java online submissions for Roman to Integer.
     */
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            switch (currentChar) {
                case 'M': {
                    result = result + 1000;
                    break;
                }
                case 'D': {
                    result = result + 500;
                    break;
                }
                case 'L': {
                    result = result + 50;
                    break;
                }
                case 'V': {
                    result = result + 5;
                    break;
                }
                case 'C': {
                    if (i + 1 < s.length()) {
                        char next = s.charAt(i + 1);
                        if (next == 'D') {
                            result = result + 400;
                            i = i + 1;
                            break;
                        }
                        if (next == 'M') {
                            result = result + 900;
                            i = i + 1;
                            break;
                        }
                        result = result + 100;
                        break;
                    }
                    result = result + 100;
                    break;
                }
                case 'X': {
                    if (i + 1 < s.length()) {
                        char next = s.charAt(i + 1);
                        if (next == 'L') {
                            result = result + 40;
                            i = i + 1;
                            break;
                        }
                        if (next == 'C') {
                            result = result + 90;
                            i = i + 1;
                            break;
                        }
                        result = result + 10;
                        break;
                    }
                    result = result + 10;
                    break;
                }
                case 'I': {
                    if (i + 1 < s.length()) {
                        char next = s.charAt(i + 1);
                        if (next == 'V') {
                            result = result + 4;
                            i = i + 1;
                            break;
                        }
                        if (next == 'X') {
                            result = result + 9;
                            i = i + 1;
                            break;
                        }
                        result = result + 1;
                        break;
                    }
                    result = result + 1;
                    break;
                }
            }
        }

        return result;
    }
}
