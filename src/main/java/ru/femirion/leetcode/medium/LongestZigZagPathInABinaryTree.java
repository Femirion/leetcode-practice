package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 1372. Longest ZigZag Path in a Binary Tree
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
 */
public class LongestZigZagPathInABinaryTree {

    /**
     * Runtime 5 ms Beats 68.56% of users with Java
     * Memory 54.69 MB Beats 65.04% of users with Java
     */
    public int longestZigZag(TreeNode root) {
        int left = 0;
        if (root.left != null) {
            left = getMaxZigZag(root.left, true, 1);
        }
        int right = 0;
        if (root.right != null) {
            right = getMaxZigZag(root.right, false, 1);
        }
        return Math.max(left, right);
    }

    private int getMaxZigZag(TreeNode node, boolean isLeft, int curSize) {
        if (node == null) {
            return curSize;
        }

        int rightMax = 0;
        int leftMax = 0;
        int newLeftMax = 0;
        int newRightMax = 0;
        if (isLeft) {
            if (node.right != null) {
                rightMax = getMaxZigZag(node.right, false, ++curSize);
            }
            if (node.left != null) {
                newLeftMax = getMaxZigZag(node.left, true, 1);
            }
            return Math.max(curSize, Math.max(rightMax, newLeftMax));
        } else {
            if (node.right != null) {
                newRightMax = getMaxZigZag(node.right, false, 1);
            }
            if (node.left != null) {
                leftMax = getMaxZigZag(node.left, true, ++curSize);
            }
            return Math.max(curSize, Math.max(newRightMax, leftMax));
        }
    }
}
