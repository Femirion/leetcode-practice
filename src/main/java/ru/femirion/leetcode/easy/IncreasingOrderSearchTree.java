package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 897. Increasing Order Search Tree
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 */
public class IncreasingOrderSearchTree {

    /**
     * Runtime 1 ms Beats 7.12% of users with Java
     * Memory 41.45 MB Beats 16.77% of users with Java
     */
    public TreeNode increasingBST(TreeNode root) {
        int[] arr = new int[1001];
        passThroughTree(root, arr);

        TreeNode result = new TreeNode();
        TreeNode head = result;

        int nodeCount = 0;
        for (int i = 0; i < 1001; i++) {
            if (arr[i] > 0) {
                nodeCount = nodeCount + arr[i];
            }
        }

        for (int i = 0; i < 1001; i++) {
            if (arr[i] > 0) {
                result.val = i;
                arr[i]--;
                i--;
                if (nodeCount > 1) {
                    result.right = new TreeNode();
                    result = result.right;
                }
                nodeCount--;
            }
        }
        return head;
    }

    private void passThroughTree(TreeNode node, int[] arr) {
        if (node == null) {
            return;
        }

        arr[node.val]++;

        passThroughTree(node.left, arr);
        passThroughTree(node.right, arr);
    }

}
