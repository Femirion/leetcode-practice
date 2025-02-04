package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 530. Minimum Absolute Difference in BST
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 */
public class MinimumAbsoluteDifferenceInBST {

    Integer prev = null;
    int min = Integer.MAX_VALUE;

    /**
     * Runtime 0 ms Beats 100.00%
     * Memory 44.74 MB Beats 32.96%
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }

        int leftMin = getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }

        prev = root.val;

        return getMinimumDifference(root.right);

    }
}
