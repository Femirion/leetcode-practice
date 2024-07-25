package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class EvaluateReversePolishNotation {

    /**
     * Runtime 7 ms Beats 31.49%
     * Memory 44.58 MB Beats 44.69%
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        int result = 0;
        for (String curStr : tokens) {
            if (stack.isEmpty()) {
                stack.push(curStr);
                continue;
            }

            if (isOperator(curStr)) {
                int right = Integer.valueOf(stack.pop());
                int left = Integer.valueOf(stack.pop());
                stack.push(proccedOperator(left, curStr, right));
            } else {
                stack.push(curStr);
            }
        }

        return Integer.valueOf(stack.pop());
    }

    private String proccedOperator(int leftOperand, String operator, int rightOperand) {
        if ("*".equals(operator)) {
            return Integer.toString(leftOperand * rightOperand);
        }
        if ("+".equals(operator)) {
            return Integer.toString(leftOperand + rightOperand);
        }
        if ("/".equals(operator)) {
            return Integer.toString(leftOperand / rightOperand);
        }
        if ("-".equals(operator)) {
            return Integer.toString(leftOperand - rightOperand);
        }
        return "";
    }

    private boolean isOperator(String str) {
        return "*".equals(str)
                || "-".equals(str)
                || "+".equals(str)
                || "/".equals(str);
    }
}
