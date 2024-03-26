package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 1448. Count Good Nodes in Binary Tree
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 *
 * #Tree
 */
public class CountGoodNodesInBinaryTree {

    private int countOfGoodNodes = 0;

    /**
     * Runtime 2 ms Beats 85.01% of users with Java
     * Memory 52.42 MB Beats 32.64% of users with Java
     */
    public int goodNodes(TreeNode root) {
        getCountOfGoodNodes(root, Integer.MIN_VALUE);
        return countOfGoodNodes;
    }

    private void getCountOfGoodNodes(TreeNode node, int maxValue) {
        if (node == null) {
            return;
        }

        if (maxValue <= node.val) {
            countOfGoodNodes++;
            maxValue = node.val;
        }

        getCountOfGoodNodes(node.left, maxValue);
        getCountOfGoodNodes(node.right, maxValue);
    }
}
