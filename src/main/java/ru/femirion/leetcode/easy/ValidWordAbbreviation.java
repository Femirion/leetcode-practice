package ru.femirion.leetcode.easy;

/**
 * 408. Valid Word Abbreviation
 * https://leetcode.com/problems/valid-word-abbreviation/description/
 */
public class ValidWordAbbreviation {

    /**
     * Runtime 1 ms Beats 97.79% of users with Java
     * Memory 41.50 MB Beats 74.83% of users with Java
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int wp = 0;
        int ap = 0;
        int currentNumber = 0;

        char current;
        char currentAbbr = abbr.charAt(ap);
        boolean isDigit = isDigit(currentAbbr);

        if (ap == 0 && isDigit) {
            return false;
        }

        while (wp < word.length() || ap < abbr.length()) {
            current = word.charAt(wp);
            currentAbbr = abbr.charAt(ap);

            isDigit = isDigit(currentAbbr);
            if (isDigit) {
                if (currentNumber == 0 && (currentAbbr - '0') == 0) {
                    return false;
                }
                currentNumber = currentNumber * 10 + (currentAbbr - '0');
                if (wp + currentNumber > word.length()) {
                    return false;
                } else {
                    ap++;
                    continue;
                }
            } else {
                if (currentNumber != 0) {
                    if (wp + currentNumber > word.length()) {
                        return false;
                    }
                    wp = wp + currentNumber;
                    current = word.charAt(wp);
                    currentNumber = 0;
                }
            }

            if (current != currentAbbr) {
                return false;
            }

            wp++;
            ap++;
        }


        if (wp + currentNumber != word.length()) {
            return false;
        }


        if (ap != abbr.length()) {
            return false;
        }

        return true;
    }

    private boolean isDigit(char digit) {
        return digit >= '0' && digit <= '9';
    }
}
