package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
public class InvertBinaryTree {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.71 MB Beats 90.09% of users with Java
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
