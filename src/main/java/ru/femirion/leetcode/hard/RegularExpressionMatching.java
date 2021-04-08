package ru.femirion.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/*
    Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).

    Example 1:

    Input: s = "aa", p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".
    Example 2:

    Input: s = "aa", p = "a*"
    Output: true
    Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
    Example 3:

    Input: s = "ab", p = ".*"
    Output: true
    Explanation: ".*" means "zero or more (*) of any character (.)".
    Example 4:

    Input: s = "aab", p = "c*a*b"
    Output: true
    Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
    Example 5:

    Input: s = "mississippi", p = "mis*is*p*."
    Output: false


    Constraints:

    0 <= s.length <= 20
    0 <= p.length <= 30
    s contains only lowercase English letters.
    p contains only lowercase English letters, '.', and '*'.
    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
    * */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        Expression[] expressions = new Expression[p.length()];
        int expressionSize = 0;
        for (int i = 0; i < p.length(); i++) {
            char current = p.charAt(i);
            if (i + 1 >= p.length()) {
                expressions[expressionSize] = new Expression(current, ' ', expressionSize);
                expressionSize++;
                break;
            }
            char next = p.charAt(i + 1);
            if (next == '*') {
                expressions[expressionSize] = new Expression(current, '*', expressionSize);
                i++;
            } else {
                expressions[expressionSize] = new Expression(current, ' ', expressionSize);
            }
            expressionSize++;
        }

        List<SafePoint> safePoints = new ArrayList<>();
        int currentPosition = 0;
        char currentSymbol = 0;
        for (int i = 0; i < expressionSize; i++) {
            Expression expression = expressions[i];
            if (currentPosition < s.length()) {
                currentSymbol = s.charAt(currentPosition);
            } else {
                currentSymbol = 0;
            }

            if (expression.exp == '*') {
                if ((expression.symbol == '.' && currentSymbol != 0) || expression.symbol == currentSymbol) {
                    safePoints.add(new SafePoint(i, currentPosition));
                    currentPosition++;
                    i--;
                    continue;
                }

                if (safePoints.size() == 0 && expression.symbol != currentSymbol) {
//                    if (currentPosition == s.length()) {
//                        continue;
//                    }
                    continue;
                }

                if (expression.symbol != currentSymbol) {
                    var safePoint = safePoints.remove(safePoints.size() - 1);
                    i = safePoint.expressionPosition;
                    currentPosition = safePoint.currentPosition + 1;
                }
                continue;
            }

            if (expression.symbol == '.') {
                currentPosition++;
                continue;
            }

            if (expression.symbol != currentSymbol) {
                if (safePoints.size() == 0) {
                    return false;
                }
                var safePoint = safePoints.remove(safePoints.size() - 1);
                i = safePoint.expressionPosition;
                currentPosition = safePoint.currentPosition + 1;
            } else {
                currentPosition++;
            }
        }

        if (currentPosition < s.length()) {
            return false;
        }

        return true;
    }

    private static class Expression {
        private final char symbol;
        private final char exp;
        private final int number;

        private Expression(char symbol, int number) {
            this.symbol = symbol;
            this.exp = 0;
            this.number = number;
        }

        private Expression(char symbol, char exp, int number) {
            this.number = number;
            this.symbol = symbol;
            this.exp = exp;
        }
    }

    private static class SafePoint {
        private final int expressionPosition;
        private final int currentPosition;

        private SafePoint(int expressionPosition, int currentPosition) {
            this.expressionPosition = expressionPosition;
            this.currentPosition = currentPosition;
        }
    }

}
