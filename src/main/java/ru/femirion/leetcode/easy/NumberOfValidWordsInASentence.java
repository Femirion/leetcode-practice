package ru.femirion.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2047. Number of Valid Words in a Sentence
 * https://leetcode.com/problems/number-of-valid-words-in-a-sentence/
 */
public class NumberOfValidWordsInASentence {

    /**
     * Runtime 3ms Beats 99.64% of users with Java
     * Memory 43.66MB Beats 58.12% of users with Java
     */
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;
        List<String> w = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (isValid(words[i], w)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(String str, List<String> w) {
        if (str.isEmpty()) {
            return false;
        }
        int countOfHyphen = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (isDigit(current)) {
                return false;
            }
            if (current == '-') {
                if (i == 0 || i == str.length() - 1 || countOfHyphen == 1
                        || isNotLetter(str.charAt(i - 1)) || isNotLetter(str.charAt(i + 1))) {
                    return false;
                } else {
                    countOfHyphen++;
                }
                continue;
            }
            if (isPunctuation(current)) {
                if (i != str.length() - 1) {
                    return false;
                }
            }
        }
        w.add(str);
        return true;
    }

    private boolean isDigit(char current) {
        return current >= '0' && current <= '9';
    }

    private boolean isPunctuation(char current) {
        return current == ',' || current == '.' || current == '!';
    }

    private boolean isNotLetter(char current) {
        return current <= 'a' || current >= 'z';
    }
}

