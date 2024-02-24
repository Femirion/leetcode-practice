package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/description/
 */
public class SameTree {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.90 MB Beats 69.82% of users with Java
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        int v1 = p.val;
        int v2 = q.val;
        if (v1 != v2) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
