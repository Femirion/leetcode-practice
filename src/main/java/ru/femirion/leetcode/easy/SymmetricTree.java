package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/description/
 */
public class SymmetricTree {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 41.53 MB Beats 72.03% of users with Java
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.val != n2.val) {
            return false;
        }

        return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }
}
