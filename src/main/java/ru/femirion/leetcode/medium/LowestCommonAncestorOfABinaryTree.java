package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * Runtime 7 ms Beats 56.83%
     * Memory 44.88 MB Beats 32.79%
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return passThroughTree(root, p.val, q.val);
    }

    private TreeNode passThroughTree(TreeNode node, int pVal, int qVal) {
        if (node == null) {
            return node;
        }

        if (node.val == pVal || node.val == qVal) {
            return node;
        }

        TreeNode left = passThroughTree(node.left, pVal, qVal);
        TreeNode right = passThroughTree(node.right, pVal, qVal);

        if (left != null && right != null) {
            return node;
        }
        return left != null ? left : right;
    }
}
