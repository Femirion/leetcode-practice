package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * #Tree
 */
public class BalancedBinaryTree {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 43.90 MB Beats 90.68% of users with Java
     */
    public boolean isBalanced(TreeNode root) {
        int result = passThroughTree(root);

        return result != -1;
    }

    private int passThroughTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = passThroughTree(node.left);
        int rightDepth = passThroughTree(node.right);


        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }

        if (1 < Math.abs(leftDepth - rightDepth)) {
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
