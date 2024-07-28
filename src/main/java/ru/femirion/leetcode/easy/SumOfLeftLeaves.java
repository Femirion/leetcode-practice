package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 */
public class SumOfLeftLeaves {

    private int sum = 0;

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 41.33 MB Beats 42.10%
     */
    public int sumOfLeftLeaves(TreeNode root) {
        passThrowTheTree(root);
        return sum;
    }

    private void passThrowTheTree(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum = sum + node.left.val;
            } else {
                passThrowTheTree(node.left);
            }
        }

        if (node.right != null) {
            sumOfLeftLeaves(node.right);
        }
    }
}
