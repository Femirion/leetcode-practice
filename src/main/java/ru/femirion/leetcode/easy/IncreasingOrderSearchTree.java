package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

import java.util.Stack;

/**
 * 897. Increasing Order Search Tree
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 */
public class IncreasingOrderSearchTree {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.18 MB Beats 49.01% of users with Java
     */
    public TreeNode increasingBST1(TreeNode root) {
        TreeNode result = new TreeNode(0);
        TreeNode target = result;
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode top = stack.pop();

            result.right = new TreeNode(top.val);
            result.left = null;
            result = result.right;

            root = top.right;
        }
        return target.right;
    }



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
