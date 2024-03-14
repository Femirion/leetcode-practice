package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/description/
 */
public class RangeSumOfBST {

    /**
     * Runtime 1 ms Beats 50.18% of users with Java
     * Memory 50.69 MB Beats 93.15% of users with Java
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        return getRangeSum(root, low, high);
    }

    private int getRangeSum(TreeNode node, int low, int high) {
        int cur = 0;
        if (node == null) {
            return cur;
        }
        if (low <= node.val && node.val <= high) {
            cur = node.val;
        }
        int leftRange = 0;
        int rightRange = 0;
        if (node.left != null) {
            leftRange = getRangeSum(node.left, low, high);
        }
        if (node.left != null) {
            rightRange = getRangeSum(node.right, low, high);
        }
        return cur + leftRange + rightRange;
    }
}
