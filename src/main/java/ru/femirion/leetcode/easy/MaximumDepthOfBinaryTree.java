package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaximumDepthOfBinaryTree {
    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 42.32 MB Beats 78.63% of users with Java
     */
    public int maxDepth(TreeNode root) {
        return getNextDepth(root, 0);
    }

    private int getNextDepth(TreeNode root, int currentDepth) {
        if (root == null) {
            return currentDepth;
        }
        currentDepth = currentDepth + 1;
        int leftDepth = getNextDepth(root.left, currentDepth);
        int rightDepth = getNextDepth(root.right, currentDepth);
        return Math.max(leftDepth, rightDepth);
    }
}
