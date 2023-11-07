package ru.femirion.leetcode.easy;

import com.sun.source.tree.Tree;

/**
 * 2331. Evaluate Boolean Binary Tree
 * https://leetcode.com/problems/evaluate-boolean-binary-tree/
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
