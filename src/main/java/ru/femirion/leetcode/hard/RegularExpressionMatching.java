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
        int currentExpressionPosition = 0;
        for (int i = 0; i < s.length(); i++) {
            if (expressionSize - 1 < currentExpressionPosition) {
                return false;
            }

            Expression expression = expressions[currentExpressionPosition];
            char currentSymbol = s.charAt(i);

            if (expression.exp == '*') {
                if (expression.symbol == '.' || expression.symbol == currentSymbol) {
                    if (s.length() == i + 1 && currentExpressionPosition + 1 != expressionSize) {
                        var safePoint = safePoints.remove(safePoints.size() - 1);
                        i = safePoint.currentPosition;
                        currentExpressionPosition = safePoint.expressionPosition + 1;
                        continue;
                    }

                    safePoints.add(new SafePoint(currentExpressionPosition, i));
                    continue;
                }

                if (safePoints.size() == 0 && expression.symbol != currentSymbol) {
                    currentExpressionPosition++;
                    i--;
                    continue;
                }

                if (expression.symbol != currentSymbol) {
                    var safePoint = safePoints.remove(safePoints.size() - 1);
                    i = safePoint.currentPosition;
                    currentExpressionPosition = safePoint.expressionPosition + 1;
                }
                continue;
            }

            if (expression.symbol == '.') {
                if (s.length() == i + 1) {
                    break;
                }
                currentExpressionPosition++;
                continue;
            }

            if (expression.symbol != currentSymbol) {
                if (safePoints.size() == 0) {
                    return false;
                }
                var safePoint = safePoints.get(safePoints.size() - 1);
                i = safePoint.currentPosition;

                if (s.length() == i + 1) {
                    break;
                }

                currentExpressionPosition++;
            } else {
                if (s.length() == i + 1) {
                    break;
                }
                currentExpressionPosition++;
            }
        }

        boolean onlyStarts = true;
        if (currentExpressionPosition + 1 != expressionSize) {
            for (int i = currentExpressionPosition + 1; i < expressionSize; i++) {
                var expression = expressions[i];
                if (expression.exp != '*') {
                    onlyStarts = false;
                }
            }
            if (onlyStarts) {
                return true;
            }
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
