package ru.femirion.leetcode.medium;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 654. Maximum Binary Tree
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class MaximumBinaryTree {

    /**
     * Runtime 2 ms Beats 57.39%
     * Memory 44.93 MB Beats 38.85%
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = new TreeNode();
        fillTreeNode(root, nums, 0, nums.length - 1);
        return root;
    }

    private void fillTreeNode(TreeNode node, int[] nums, int start, int end) {
        int maxValue = nums[start];
        int maxIdx = start;
        for (int i = start; i <= end; i++) {
            if (maxValue < nums[i]) {
                maxIdx = i;
                maxValue = nums[i];
            }
        }

        node.val = maxValue;
        if (maxIdx == start) {
            node.left = null;
        } else {
            node.left = new TreeNode();
            fillTreeNode(node.left, nums, start, maxIdx - 1);
        }
        if (maxIdx == end) {
            node.right = null;
        } else {
            node.right = new TreeNode();
            fillTreeNode(node.right, nums, maxIdx + 1, end);
        }
    }
}
