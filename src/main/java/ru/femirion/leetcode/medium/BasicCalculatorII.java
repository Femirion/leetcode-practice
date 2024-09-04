package ru.femirion.leetcode.medium;

/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/description/
 */
public class BasicCalculatorII {

    private int readIdx = 0;
    private int writeIdx = 0;

    /**
     * Runtime 36 ms Beats 14.29%
     * Memory 48.50 MB Beats 9.83%
     */
    public int calculate(String s) {
        char[] chars = s.toCharArray();

        char[] charsAfterFirstPhase = new char[chars.length];
        Integer first = null;
        Integer second = null;

        while (readIdx < chars.length) {
            char c = chars[readIdx];
            if (isDigit(c)) {
                first = getNextInt(chars, chars.length);
                continue;
            }
            if (isPriorityOperator(c)) {
                readIdx++;
                second = getNextInt(chars, chars.length);
                int result = eval(first, c, second);
                first = result;
                continue;
            }
            if (isOperator(c)) {
                writeResultToArray(charsAfterFirstPhase, first);
                charsAfterFirstPhase[writeIdx] = c;
                writeIdx++;
                readIdx++;
            } else {
                readIdx++;
            }
        }

        writeResultToArray(charsAfterFirstPhase, first);

        readIdx = 0;
        int result = 0;
        second = null;
        while (readIdx < writeIdx) {
            char c = charsAfterFirstPhase[readIdx];
            if (isDigit(c)) {
                first = getNextInt(charsAfterFirstPhase, writeIdx);
                continue;
            }
            if (isOperator(c)) {
                readIdx++;
                second = getNextInt(charsAfterFirstPhase, writeIdx);
                int tmpResult = eval(first, c, second);
                first = tmpResult;
            } else {
                readIdx++;
            }
        }

        return first;
    }

    private void writeResultToArray(char[] chars, int result) {
        StringBuilder sb = new StringBuilder();
        sb.append(result);
        for (int i = 0; i < sb.length(); i++) {
            chars[writeIdx] = sb.charAt(i);
            writeIdx++;
        }
    }

    private int eval(int first, char operator, int second) {
        if (operator == '*') {
            return first * second;
        }
        if (operator == '/') {
            return first / second;
        }
        if (operator == '+') {
            return first + second;
        }
        if (operator == '-') {
            return first - second;
        }
        throw new IllegalArgumentException();
    }

    private int getNextInt(char[] chars, int end) {
        StringBuilder sb = new StringBuilder();
        while (readIdx < end) {
            if (isDigit(chars[readIdx])) {
                sb.append(chars[readIdx]);
                readIdx++;
                continue;
            }
            if (isOperator(chars[readIdx])) {
                break;
            }
            readIdx++;
        }
        return Integer.parseInt(sb.toString());
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private boolean isPriorityOperator(char c) {
        return '*' == c || '/' == c;
    }

    private boolean isOperator(char c) {
        return '*' == c
                || '/' == c
                || '-' == c
                || '+' == c;
    }
}
