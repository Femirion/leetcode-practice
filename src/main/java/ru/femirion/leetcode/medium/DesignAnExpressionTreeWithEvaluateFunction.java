package ru.femirion.leetcode.medium;

import java.util.Stack;

/**
 * 1628. Design an Expression Tree With Evaluate Function
 * https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/description/
 */
public class DesignAnExpressionTreeWithEvaluateFunction {

    /**
     * Runtime 2 ms Beats 100.00%
     * Memory 41.02 MB Beats 75.71%
     */
    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    };

    class NumNode extends Node {
        private int num;

        public int evaluate() {
            return num;
        }

        public NumNode(String num) {
            this.num = Integer.valueOf(num);
        }
    }

    class OperatorNode extends Node {
        private char operator;
        private Node left;
        private Node right;

        public OperatorNode() {}

        public void setOperator(char o) {
            this.operator = o;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int evaluate() {
            if (operator == '-') {
                return left.evaluate() - right.evaluate();
            } else if (operator == '+') {
                return left.evaluate() + right.evaluate();
            } else if (operator == '*') {
                return left.evaluate() * right.evaluate();
            } else if (operator == '/') {
                return left.evaluate() / right.evaluate();
            }
            return -1;
        }
    }


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree representing it as a Node.
     */

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            if (postfix.length == 1) {
                return new NumNode(postfix[0]);
            }

            Stack<Node> stack = new Stack<>();

            for (String cur : postfix) {
                if (isOperator(cur)) {
                    OperatorNode node = new OperatorNode();
                    node.setOperator(cur.charAt(0));
                    node.setRight(stack.pop());
                    node.setLeft(stack.pop());
                    stack.push(node);
                } else {
                    stack.push(new NumNode(cur));
                }
            }

            return stack.pop();
        }

        private boolean isOperator(String s) {
            return "-".equals(s)
                    || "+".equals(s)
                    || "*".equals(s)
                    || "/".equals(s);
        }
    };
}
