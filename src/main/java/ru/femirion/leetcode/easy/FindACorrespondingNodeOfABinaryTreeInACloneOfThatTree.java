package ru.femirion.leetcode.easy;

import ru.femirion.leetcode.utils.TreeNode;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/
 *
 * #Tree
 */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    /**
     * Runtime 1 ms Beats 99.12% of users with Java
     * Memory 49.11 MB Beats 83.89% of users with Java
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return findTargetCopy(cloned, target.val);
    }

    private TreeNode findTargetCopy(TreeNode cloned, int targetValue) {
        if (cloned == null) {
            return null;
        }

        var t = cloned.val;

        if (cloned.val == targetValue) {
            return cloned;
        }

        TreeNode leftNode = findTargetCopy(cloned.left, targetValue);
        if (leftNode != null) {
            return leftNode;
        }

        TreeNode rightNode = findTargetCopy(cloned.right, targetValue);
        if (rightNode != null) {
            return rightNode;
        }

        return null;
    }
}
