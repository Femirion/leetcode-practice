package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
 */
public class BinarySearchTreeToGreaterSumTree {

    private int curSum;

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.15 MB Beats 41.63%
     */
    public TreeNode bstToGst(TreeNode root) {
        passThroughTree(root);
        return root;
    }

    public void passThroughTree(TreeNode node) {
        if (node == null) {
            return;
        }

        passThroughTree(node.right);
        curSum = curSum + node.val;
        node.val = curSum;
        passThroughTree(node.left);
    }
}
