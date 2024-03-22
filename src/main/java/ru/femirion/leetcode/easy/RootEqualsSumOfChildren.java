package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 2236. Root Equals Sum of Children
 * https://leetcode.com/problems/root-equals-sum-of-children/description/
 *
 * #Tree
 */
public class RootEqualsSumOfChildren {

    /**
     * Runtime 0 ms Beats 100.00% of users with Java
     * Memory 40.60 MB Beats 98.86% of users with Java
     */
    public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }
}
