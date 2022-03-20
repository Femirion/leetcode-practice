package ru.femirion.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
    Given a string s, return the longest palindromic substring in s.

    Example 1:

    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: s = "cbbd"
    Output: "bb"
    Example 3:

    Input: s = "a"
    Output: "a"
    Example 4:

    Input: s = "ac"
    Output: "a"


    Constraints:
    1 <= s.length <= 1000
    s consist of only digits and English letters (lower-case and/or upper-case),
* */
public class LongestPalindromicSubstring {
    private final String EMPTY = "";
    private Map<String, Boolean> computedPalindrome = new HashMap<>();
    private Map<String, Character> predictedPalindrome = new HashMap<>();

    public String longestPalindrome(String s) {
        computedPalindrome.clear();
        predictedPalindrome.clear();
        var maxPalindrome = EMPTY;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                var result = getPalindrome(s, i, j);
                maxPalindrome = result.length() > maxPalindrome.length()
                        ? result : maxPalindrome;
            }
        }

        List<Map.Entry<String, Character>> r = predictedPalindrome.entrySet().stream()
                .filter(st -> st.getKey().length() == 3)
                .collect(Collectors.toList());

        return maxPalindrome;
    }

    private String getPalindrome(String s, int startIndex, int stopIndex) {
        var current = s.substring(startIndex, stopIndex - 1);
        var next = s.substring(startIndex, stopIndex);

        var isComputedPalindrome = computedPalindrome.get(next);
        if (isComputedPalindrome != null) {
            return isComputedPalindrome ? current : EMPTY;
        }

        var predict = predictedPalindrome.get(current);
        if (predict != null) {
            char lastChar = s.charAt(stopIndex - 1);
            if (!predict.equals(lastChar)) {
                computedPalindrome.put(current, false);
                var nextPredict = predictCharForPalindrome(s, stopIndex);
                predictedPalindrome.put(next, nextPredict);
                return EMPTY;
            }
        }

        int i = startIndex;
        int j = stopIndex;
        while(i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j - 1);
            if (left != right) {
                computedPalindrome.put(current, false);
                char predictedChar = predictCharForPalindrome(s, stopIndex);
                predictedPalindrome.put(next, predictedChar);
                return EMPTY;
            }
            i++;
            j--;
        }
        computedPalindrome.put(next, true);
        char predictedChar = predictCharForPalindrome(s, stopIndex);
        predictedPalindrome.put(next, predictedChar);
        return next;
    }

    private char predictCharForPalindrome(String s, int index) {
        return s.charAt(index - 1);
    }
}
