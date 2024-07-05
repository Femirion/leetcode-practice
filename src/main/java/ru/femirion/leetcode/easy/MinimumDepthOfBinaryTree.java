package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 * #Tree
 */
public class MinimumDepthOfBinaryTree {

    /**
     * Runtime 6 ms Beats 30.33%
     * Memory 63.40 MB Beats 27.34%
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countDepth(root, 1);
    }

    private int countDepth(TreeNode node, int currDepth) {
        if (node.left == null && node.right == null) {
            return currDepth;
        }

        int leftDepth = (node.left != null) ? countDepth(node.left, currDepth + 1) : Integer.MAX_VALUE;
        int rightDepth = (node.right != null) ? countDepth(node.right, currDepth + 1) : Integer.MAX_VALUE;

        return Math.min(leftDepth, rightDepth);
    }
}
