package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 */
public class CountCompleteTreeNodes {

    private int count = 0;

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 47.44 MB Beats 66.64% of users with Java
     */
    public int countNodes(TreeNode root) {
        getCount(root);
        return count;
    }

    private void getCount(TreeNode root) {
        if (root == null) {
            return;
        }

        count = count + 1;
        if (root.left == null && root.right == null) {
            return;
        }

        getCount(root.left);
        getCount(root.right);
    }
}
