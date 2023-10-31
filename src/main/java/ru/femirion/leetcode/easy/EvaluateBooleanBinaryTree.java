package ru.femirion.leetcode.easy;

import com.sun.source.tree.Tree;

/**
 * 2331. Evaluate Boolean Binary Tree
 * <p>
 * https://leetcode.com/problems/evaluate-boolean-binary-tree/
 * <p>
 * You are given the root of a full binary tree with the following properties:
 * <p>
 * Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
 * Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
 * The evaluation of a node is as follows:
 * <p>
 * If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
 * Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
 * Return the boolean result of evaluating the root node.
 * <p>
 * A full binary tree is a binary tree where each node has either 0 or 2 children.
 * <p>
 * A leaf node is a node that has zero children.
 */
public class EvaluateBooleanBinaryTree {

    /**
     * 0ms Beats 100.00% of users with Java
     * 43.19MB Beats 37.20%of users with Java if currentOperation is int
     * 42.90MB Beats 75.83%of users with Java if currentOperation is byte
     * 42.55MB Beats 96.69%of users with Java if use (left != null || right != null) instead (left != null && right != null)
     */
    public boolean evaluateTree(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        boolean result = root.val != 0;
        if (left != null || right != null) {
            byte currentOperation = (byte) root.val;
            boolean leftValue = evaluateTree(left);
            boolean rightValue = evaluateTree(right);
            result = computeOperation(currentOperation, leftValue, rightValue);
        }
        return result;
    }

    private boolean computeOperation(byte operation, boolean leftValue, boolean rightValue) {
        return operation == 2 ? leftValue || rightValue : leftValue && rightValue;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
