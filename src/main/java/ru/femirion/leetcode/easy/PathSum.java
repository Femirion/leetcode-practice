package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/description/
 */
public class PathSum {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 43.06 MB Beats 51.32% of users with Java
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkPath(root, 0, targetSum);
    }

    private boolean checkPath(TreeNode root, int currentSum, int target) {
        if (root == null) {
            return false;
        }
        int tmp = currentSum + root.val;
        if (tmp == target && root.left == null & root.right == null) {
            return true;
        }
        return checkPath(root.left, tmp, target) || checkPath(root.right, tmp, target);
    }
}
